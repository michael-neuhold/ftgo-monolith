package net.chrisrichardson.ftgo.courierservice.external.mapper;

import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.courierservice.external.model.AddressExternal;
import net.chrisrichardson.ftgo.courierservice.external.model.CourierExternal;
import net.chrisrichardson.ftgo.domain.Courier;

public class CourierToCourierExternalMapper {

    public static CourierExternal toExternal(Courier courier) {
        return new CourierExternal(
                courier.getId(),
                courier.getName().getFirstName(),
                courier.getName().getLastName(),
                true,
                toExternal(courier.getAddress()));
    }

    private static AddressExternal toExternal(Address address) {
        return new AddressExternal(
                address.getStreet1(),
                address.getCity(),
                address.getState(),
                address.getZip()
        );
    }

}
