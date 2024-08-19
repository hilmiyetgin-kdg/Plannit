package com.hilmiyetgin.plannit.domain;
import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROFILE")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @NotBlank
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Transient
    @NotBlank
    private String password;
    @NotBlank
    @Column
    private String firstName;
    @NotBlank
    @Column
    private String lastName;
    @NotBlank
    @Column
    private String phoneNumber;
    @OneToMany(mappedBy = "organizer" ,fetch = FetchType.LAZY)
    private Set<Event> organizedEvents;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<Invitation> attendedEvents;

    public Profile() {
    }

    public Profile(String username, String email, String password, String firstName, String lastName, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.organizedEvents = new HashSet<>();
        this.attendedEvents = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Event> getOrganizedEvents() {
        return organizedEvents;
    }

    public void setOrganizedEvents(Set<Event> organizedEvents) {
        this.organizedEvents = organizedEvents;
    }

    public Set<Invitation> getAttendedEvents() {
        return attendedEvents;
    }

    public void setAttendedEvents(Set<Invitation> attendedEvents) {
        this.attendedEvents = attendedEvents;
    }
}
