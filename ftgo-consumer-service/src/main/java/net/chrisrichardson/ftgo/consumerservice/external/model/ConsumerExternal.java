package net.chrisrichardson.ftgo.consumerservice.external.model;

public class ConsumerExternal {

    public ConsumerExternal(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private Long id;

    private String firstName;

    private String lastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
