package net.chrisrichardson.ftgo.courierservice.parallel;

import io.sentry.Sentry;
import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.courierservice.CourierService;
import net.chrisrichardson.ftgo.domain.Action;
import net.chrisrichardson.ftgo.domain.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("courier-service-parallel")
public class CourierServiceParallelImpl implements CourierService {

    @Autowired
    @Qualifier("courier-service-internal")
    CourierService courierServiceInternal;

    @Autowired
    @Qualifier("courier-service-external")
    CourierService courierServiceExternal;

    @Override
    public void hello() {
        System.out.println("Hello from Courier Service Parallel");
    }

    @Override
    public Courier createCourier(PersonName name, Address address) {
        Courier createdCourierInternal = courierServiceInternal.createCourier(name, address);
        Courier createdCourierExternal = courierServiceExternal.createCourier(name, address);

        if (!createdCourierInternal.getId().equals(createdCourierExternal.getId())) {
            Sentry.captureException(new Exception("Internal and externally created courier diverge."));
        }

        return createdCourierInternal;
    }

    @Override
    public void updateAvailability(long courierId, boolean available) {
        // TODO check
    }

    @Override
    public Optional<Courier> findCourierById(long courierId) {
        Optional<Courier> foundCourierInternal = courierServiceInternal.findCourierById(courierId);
        Optional<Courier> foundCourierExternal = courierServiceExternal.findCourierById(courierId);

        if (foundCourierExternal.isPresent() && !foundCourierInternal.isPresent()) {
            Sentry.captureException(new Exception("Internal and externally found courier diverge."));
        }

        return foundCourierInternal;
    }

    @Override
    public List<Courier> findAll() {
        List<Courier> allCouriersInternal = courierServiceInternal.findAll();
        List<Courier> allCouriersExternal = courierServiceExternal.findAll();

        if (allCouriersInternal.size() != allCouriersExternal.size()) {
            Sentry.captureException(new Exception("Internal and external couriers diverge."));
        }

        return allCouriersInternal;
    }

    @Override
    public List<Courier> findAllAvailable() {
        List<Courier> allAvailableCouriersInternal = courierServiceInternal.findAllAvailable();
        List<Courier> allAvailableCouriersExternal = courierServiceExternal.findAllAvailable();

        if (allAvailableCouriersExternal.size() != allAvailableCouriersInternal.size()) {
            Sentry.captureException(new Exception("Internal and external couriers diverge."));
        }

        return allAvailableCouriersExternal;
    }

    @Override
    public void addAction(Courier courier, Action action) {
        // TODO check
    }

}
