package net.chrisrichardson.ftgo.consumerservice.external.model;

public class ConsumerExternal {

    public ConsumerExternal() {
    }

    public ConsumerExternal(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


}
