package net.chrisrichardson.ftgo.courierservice.external;

import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.courierservice.CourierService;
import net.chrisrichardson.ftgo.courierservice.external.client.CourierServiceClient;
import net.chrisrichardson.ftgo.courierservice.external.exception.CourierServiceExternalException;
import net.chrisrichardson.ftgo.courierservice.external.mapper.CourierExternalToCourierMapper;
import net.chrisrichardson.ftgo.courierservice.external.mapper.CourierToCourierExternalMapper;
import net.chrisrichardson.ftgo.courierservice.external.model.ActionExternal;
import net.chrisrichardson.ftgo.courierservice.external.model.CourierExternal;
import net.chrisrichardson.ftgo.domain.Action;
import net.chrisrichardson.ftgo.domain.Consumer;
import net.chrisrichardson.ftgo.domain.Courier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static net.chrisrichardson.ftgo.courierservice.external.constants.LogConstants.EXTERNAL_COURIER_SERVICE;

@Service
@Qualifier("courier-service-external")
public class CourierServiceExternalImpl implements CourierService {

    @Autowired
    CourierServiceClient courierServiceClient;

    private static final Logger LOG = LoggerFactory.getLogger(CourierServiceExternalImpl.class);

    @Override
    public void hello() {
        System.out.println("Hello from Consumer Service External");
    }

    @Override
    public Courier createCourier(PersonName name, Address address) {
        LOG.info(EXTERNAL_COURIER_SERVICE + ": Create courier.");

        Optional<CourierExternal> createdCourier = courierServiceClient
                .create(CourierToCourierExternalMapper.toExternal(new Courier(name, address)));

        if (createdCourier.isPresent()) {
            return CourierExternalToCourierMapper.toDomain(createdCourier.get());
        } else {
            throw new CourierServiceExternalException("Courier could not be created. External consumer service error.");
        }
    }

    @Override
    public void updateAvailability(long courierId, boolean available) {
        LOG.info(EXTERNAL_COURIER_SERVICE + ": find courier by id and update availability");
        Optional<CourierExternal> courierToUpdate = courierServiceClient.findById(courierId);
        if (courierToUpdate.isPresent()) {
            courierToUpdate.get().setAvailability(available);
            courierServiceClient.update(courierToUpdate.get());
        }
    }

    @Override
    public Optional<Courier> findCourierById(long courierId) {
        LOG.info(EXTERNAL_COURIER_SERVICE + ": find courier by id.");
        return courierServiceClient.findById(courierId)
                .map(CourierExternalToCourierMapper::toDomain);
    }

    @Override
    public List<Courier> findAll() {
        LOG.info(EXTERNAL_COURIER_SERVICE + ": find all couriers.");
        return courierServiceClient.findAll().stream()
                .map(CourierExternalToCourierMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Courier> findAllAvailable() {
        LOG.info(EXTERNAL_COURIER_SERVICE + ": find available couriers.");
        return courierServiceClient.findAll().stream()
                .map(CourierExternalToCourierMapper::toDomain)
                .filter(Courier::isAvailable)
                .collect(Collectors.toList());
    }

    @Override
    public void addAction(Courier courier, Action action) {
        LOG.info(EXTERNAL_COURIER_SERVICE + ": add action to courier.");
        courierServiceClient.createActionForCourier(
                new ActionExternal(
                        action.getType(),
                        action.getTime(),
                        action.getOrder().getId(),
                        courier.getId()
                )
        );
    }

}
