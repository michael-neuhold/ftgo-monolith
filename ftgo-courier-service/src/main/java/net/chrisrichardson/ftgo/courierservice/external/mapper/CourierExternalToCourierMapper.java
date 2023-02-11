package net.chrisrichardson.ftgo.courierservice.external.mapper;

import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.courierservice.external.model.AddressExternal;
import net.chrisrichardson.ftgo.courierservice.external.model.CourierExternal;
import net.chrisrichardson.ftgo.domain.Courier;

public class CourierExternalToCourierMapper {

    public static Courier toDomain(CourierExternal courierExternal) {
        Courier courier = new Courier(
                new PersonName(
                        courierExternal.getFirstName(),
                        courierExternal.getLastName()),
                toInternal(courierExternal.getAddress()));

        courier.setId(courierExternal.getId());
        courier.setAvailable(courierExternal.isAvailability());

        return courier;
    }

    private static Address toInternal(AddressExternal address) {
        return new Address(
                address.getStreet(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip()
        );
    }

}
