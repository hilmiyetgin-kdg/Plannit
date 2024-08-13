package com.hilmiyetgin.plannit.service;

import com.hilmiyetgin.plannit.domain.Profile;
import com.hilmiyetgin.plannit.exceptions.DuplicateProfileException;
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

    //create
    public Profile addProfile(String username, String email, String password, String firstName, String lastName, String phoneNumber){
        if (profileRepository.existsByUsername(username)) {
            throw new DuplicateProfileException(String.format("Username '%s' is already taken", username));
        }

        if (profileRepository.existsByEmail(email)) {
            throw new DuplicateProfileException(String.format("There is already an account for the email '%s'", email));
        }

        Profile profile = new Profile(username, email, password, firstName, lastName, phoneNumber);
        return profileRepository.save(profile);
    }

    //read
    public Profile getProfileById(long id){
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
    }

    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }


}
