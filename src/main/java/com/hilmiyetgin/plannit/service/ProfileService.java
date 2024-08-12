package com.hilmiyetgin.plannit.service;

import com.hilmiyetgin.plannit.domain.Profile;
import com.hilmiyetgin.plannit.exceptions.ProfileNotFoundException;
import com.hilmiyetgin.plannit.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfileById(long id){
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
    }

    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

}
