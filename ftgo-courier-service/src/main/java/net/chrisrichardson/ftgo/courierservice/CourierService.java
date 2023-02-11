package net.chrisrichardson.ftgo.courierservice;

import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.domain.Courier;

public interface CourierService {

    void hello();

    Courier createCourier(PersonName name, Address address);

    void updateAvailability(long courierId, boolean available);

}
