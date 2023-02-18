package net.chrisrichardson.ftgo.courierservice;

import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.domain.Action;
import net.chrisrichardson.ftgo.domain.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierService {

    void hello();

    Courier createCourier(PersonName name, Address address);

    void updateAvailability(long courierId, boolean available);

    Optional<Courier> findCourierById(long courierId);

    List<Courier> findAll();

    List<Courier> findAllAvailable();

    void addAction(Courier courier, Action action);

}
