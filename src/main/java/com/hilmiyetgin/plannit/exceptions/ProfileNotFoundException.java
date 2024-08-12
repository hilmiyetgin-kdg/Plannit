package com.hilmiyetgin.plannit.exceptions;

public class ProfileNotFoundException extends RuntimeException{
    public ProfileNotFoundException(long id) {
        super("Profile with id " + id + " not found");
    }
}
