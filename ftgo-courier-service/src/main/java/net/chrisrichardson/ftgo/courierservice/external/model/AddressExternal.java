package net.chrisrichardson.ftgo.courierservice.external.model;

public class AddressExternal {

    public AddressExternal() {
    }

    public AddressExternal(String street1, String street2, String city, String state, String zip) {
        this.street1 = street1;
        this.street2= street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
