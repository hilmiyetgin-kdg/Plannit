package com.hilmiyetgin.plannit.domain;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(nullable = false, unique = true, length = 50)
    private String title;
    @NotBlank
    @Column(nullable = false)
    private String description;
    @NotBlank
    @Column(nullable = false)
    private String location;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime startDate;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime endDate;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Profile organizer;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<UserEvent> attendees;

    public Event() {
    }

    public Event(String title, String description, String location, LocalDateTime startDate, LocalDateTime endDate, Profile organizer, Set<UserEvent> attendees) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.organizer = organizer;
        this.attendees = attendees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Profile getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Profile organizer) {
        this.organizer = organizer;
    }

    public Set<UserEvent> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<UserEvent> attendees) {
        this.attendees = attendees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
