package com.hilmiyetgin.plannit.presentation;

import com.hilmiyetgin.plannit.domain.Profile;
import com.hilmiyetgin.plannit.presentation.DTO.ProfileDTO;
import com.hilmiyetgin.plannit.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    public ProfileController(ProfileService profileService, ModelMapper modelMapper) {
        this.profileService = profileService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable long id){
        Profile profile = profileService.getProfileById(id);
        if (profile == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(modelMapper.map(profile, ProfileDTO.class));
    }


}
