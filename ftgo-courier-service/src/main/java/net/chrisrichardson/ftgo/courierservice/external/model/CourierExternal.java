package net.chrisrichardson.ftgo.courierservice.external.model;

public class CourierExternal {

    public CourierExternal(Long id, String firstName, String lastName, boolean availability, AddressExternal address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.availability = availability;
        this.address = address;
    }

    private Long id;

    private String firstName;

    private String lastName;

    private boolean availability;

    private AddressExternal address;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAvailability() {
        return availability;
    }

    public AddressExternal getAddress() {
        return address;
    }
}
