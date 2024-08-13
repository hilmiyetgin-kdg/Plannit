package com.hilmiyetgin.plannit.presentation;

import com.hilmiyetgin.plannit.domain.Profile;
import com.hilmiyetgin.plannit.exceptions.DuplicateProfileException;
import com.hilmiyetgin.plannit.exceptions.ProfileNotFoundException;
import com.hilmiyetgin.plannit.presentation.DTO.NewProfileDTO;
import com.hilmiyetgin.plannit.presentation.DTO.ProfileDTO;
import com.hilmiyetgin.plannit.presentation.DTO.UpdateProfileDTO;
import com.hilmiyetgin.plannit.service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    public ProfileController(ProfileService profileService, ModelMapper modelMapper) {
        this.profileService = profileService;
        this.modelMapper = modelMapper;
    }

    //create
    @PostMapping
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody @Valid NewProfileDTO dto){
        try {
            Profile newProfile = profileService.addProfile(dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getPhoneNumber());
            ProfileDTO responseDTO = modelMapper.map(newProfile, ProfileDTO.class);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (DuplicateProfileException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    //read
    @GetMapping("{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable long id){
        Profile profile = profileService.getProfileById(id);
        if (profile == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(modelMapper.map(profile, ProfileDTO.class));
    }

    @GetMapping()
    public ResponseEntity<List<ProfileDTO>> getAllProfiles(){
        List<Profile> allProfiles = profileService.getAllProfiles();
        List<ProfileDTO> dtos = allProfiles.stream().map(p -> modelMapper.map(p, ProfileDTO.class)).toList();
        return ResponseEntity.ok(dtos);
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity<?> updateProfile(@PathVariable long id, @RequestBody @Valid UpdateProfileDTO dto){
        try {
            Profile updatedProfile = profileService.updateProfile(id, dto);
            ProfileDTO responseDTO = modelMapper.map(updatedProfile, ProfileDTO.class);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (ProfileNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProfileById(@PathVariable long id){
        try {
            profileService.deleteProfileById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (ProfileNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
