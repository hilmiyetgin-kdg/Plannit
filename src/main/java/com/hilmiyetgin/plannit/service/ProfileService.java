package com.hilmiyetgin.plannit.service;

import com.hilmiyetgin.plannit.domain.Profile;
import com.hilmiyetgin.plannit.exceptions.DuplicateProfileException;
import com.hilmiyetgin.plannit.exceptions.ProfileNotFoundException;
import com.hilmiyetgin.plannit.presentation.DTO.NewProfileDTO;
import com.hilmiyetgin.plannit.presentation.DTO.UpdateProfileDTO;
import com.hilmiyetgin.plannit.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    //create
    @Transactional
    public Profile addProfile(NewProfileDTO dto){

        if (profileRepository.existsByUsername(dto.getUsername())) {
            throw new DuplicateProfileException(String.format("Username '%s' is already taken", dto.getUsername()));
        }

        if (profileRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateProfileException(String.format("There is already an account for the email '%s'", dto.getEmail()));
        }

        //TODO: check password
        //TODO: encrypt password

        Profile profile = new Profile(dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getPhoneNumber());
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

    //update
    @Transactional
    public Profile updateProfile(long id, UpdateProfileDTO updatedProfile){
        Profile existingProfile = profileRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException(id));

        existingProfile.setUsername(updatedProfile.getUsername());
        existingProfile.setEmail(updatedProfile.getEmail());
        existingProfile.setFirstName(updatedProfile.getFirstName());
        existingProfile.setLastName(updatedProfile.getLastName());
        existingProfile.setPhoneNumber(updatedProfile.getPhoneNumber());
        //TODO: update password

        return profileRepository.save(existingProfile);

    }

    //delete
    @Transactional
    public void deleteProfileById(long id){
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new ProfileNotFoundException(id));
        profileRepository.delete(profile);
    }

}
