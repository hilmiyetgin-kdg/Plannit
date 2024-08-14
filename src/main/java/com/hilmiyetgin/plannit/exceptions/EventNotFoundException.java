package com.hilmiyetgin.plannit.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(long id) {
        super("Event with id " + id  + " not found");
    }
}
