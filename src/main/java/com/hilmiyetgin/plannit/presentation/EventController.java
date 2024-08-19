package com.hilmiyetgin.plannit.presentation;

import com.hilmiyetgin.plannit.domain.Event;
import com.hilmiyetgin.plannit.exceptions.EventNotFoundException;
import com.hilmiyetgin.plannit.exceptions.InvalidDateException;
import com.hilmiyetgin.plannit.exceptions.ProfileNotFoundException;
import com.hilmiyetgin.plannit.presentation.DTO.EventDTO;
import com.hilmiyetgin.plannit.presentation.DTO.NewEventDTO;
import com.hilmiyetgin.plannit.repository.EventRepository;
import com.hilmiyetgin.plannit.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;
    private final ModelMapper modelMapper;

    public EventController(EventService eventService, ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    //create
    @PostMapping()
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody NewEventDTO dto){
        try{
            Event event = eventService.addEvent(dto);
            EventDTO responseDTO = modelMapper.map(event, EventDTO.class);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (ProfileNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (InvalidDateException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    //read
    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable long id){
        try{
            Event event = eventService.getEventById(id);
            EventDTO responseDTO = modelMapper.map(event, EventDTO.class);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (EventNotFoundException e){
            throw new EventNotFoundException(id);
        }
    }


    //update
    //delete
}
