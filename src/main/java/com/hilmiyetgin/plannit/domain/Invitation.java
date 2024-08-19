package com.hilmiyetgin.plannit.domain;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"profile_id", "event_id"})})
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;
    @Enumerated(EnumType.STRING)
    private Status rsvpStatus;
    @NotNull
    private LocalDateTime timestamp;

    public Invitation() {
    }

    public Invitation(Profile profile, Event event, Status rsvpStatus, LocalDateTime timestamp) {
        this.profile = profile;
        this.event = event;
        this.rsvpStatus = rsvpStatus;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Status getRsvpStatus() {
        return rsvpStatus;
    }

    public void setRsvpStatus(Status rsvpStatus) {
        this.rsvpStatus = rsvpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
