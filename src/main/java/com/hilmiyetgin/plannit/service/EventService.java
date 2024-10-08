package com.hilmiyetgin.plannit.service;

import com.hilmiyetgin.plannit.domain.Event;
import com.hilmiyetgin.plannit.domain.Invitation;
import com.hilmiyetgin.plannit.domain.Profile;
import com.hilmiyetgin.plannit.domain.Status;
import com.hilmiyetgin.plannit.exceptions.EventNotFoundException;
import com.hilmiyetgin.plannit.exceptions.InvalidDateException;
import com.hilmiyetgin.plannit.exceptions.ProfileNotFoundException;
import com.hilmiyetgin.plannit.presentation.DTO.NewEventDTO;
import com.hilmiyetgin.plannit.repository.EventRepository;
import com.hilmiyetgin.plannit.repository.ProfileRepository;
import com.hilmiyetgin.plannit.repository.InvitationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ProfileRepository profileRepository;
    private final InvitationRepository invitationRepository;
    private final ModelMapper modelMapper;

    public EventService(EventRepository eventRepository, ProfileRepository profileRepository, InvitationRepository invitationRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.profileRepository = profileRepository;
        this.invitationRepository = invitationRepository;
        this.modelMapper = modelMapper;
    }

    //create
    @Transactional
    public Event addEvent(NewEventDTO dto){
        if (dto.getStartDate().isBefore(LocalDateTime.now())) {
            throw new InvalidDateException("Start date must be in the future");
        }

        if (dto.getEndDate().isBefore(LocalDateTime.now())) {
            throw new InvalidDateException("End date must be in the future");
        }

        Profile organizer = profileRepository.findById(dto.getOrganizerId()).orElseThrow(() -> new ProfileNotFoundException(dto.getOrganizerId()));

        Event newEvent = modelMapper.map(dto, Event.class);
        newEvent.setOrganizer(organizer);
        newEvent.setAttendees(new HashSet<>());
        newEvent = eventRepository.save(newEvent);

        Invitation invitation = new Invitation();
        invitation.setProfile(organizer);
        invitation.setEvent(newEvent);
        invitation.setRsvpStatus(Status.ATTENDING);
        invitation.setTimestamp(LocalDateTime.now());
        invitationRepository.save(invitation);

        newEvent.getAttendees().add(invitation);
        newEvent = eventRepository.save(newEvent);

        organizer.getOrganizedEvents().add(newEvent);
        profileRepository.save(organizer);

        return newEvent;
    }


    //read
    public Event getEventById(long id){
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<Event> getEventsByOrganizer(long organizerId) {
        Profile organizer = profileRepository.findById(organizerId)
                .orElseThrow(() -> new ProfileNotFoundException(organizerId));

        return eventRepository.findByOrganizer(organizer);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }


    //update


    //delete
    public void deleteEventById(long id){
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
        eventRepository.delete(event);
    }
}
