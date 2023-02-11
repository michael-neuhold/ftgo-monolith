package net.chrisrichardson.ftgo.courierservice.parallel;

import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.courierservice.CourierService;
import net.chrisrichardson.ftgo.domain.Courier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("courier-service-parallel")
public class CourierServiceParallelImpl implements CourierService {

    @Override
    public void hello() {
        System.out.println("Hello from Courier Service Parallel");
    }

    @Override
    public Courier createCourier(PersonName name, Address address) {
        // TODO
        return null;
    }

    @Override
    public void updateAvailability(long courierId, boolean available) {
        // TODO
    }

}
