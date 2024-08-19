package com.hilmiyetgin.plannit.service;

import com.hilmiyetgin.plannit.repository.InvitationRepository;
import org.springframework.stereotype.Service;

@Service
public class InvitationService {

    private final InvitationRepository invitationRepository;

    public InvitationService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    //create
    //read
    //update
    //delete
}
