package net.chrisrichardson.ftgo.courierservice.external.model;

public class CourierExternal {

    public CourierExternal() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setAddress(AddressExternal address) {
        this.address = address;
    }
}
