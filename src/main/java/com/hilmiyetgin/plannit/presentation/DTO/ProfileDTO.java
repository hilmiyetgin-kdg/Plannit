package com.hilmiyetgin.plannit.presentation.DTO;

public class ProfileDTO {
    private long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id;  }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
