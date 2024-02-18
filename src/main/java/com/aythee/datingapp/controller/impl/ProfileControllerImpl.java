package com.aythee.datingapp.controller.impl;

import com.aythee.datingapp.controller.ProfileController;
import com.aythee.datingapp.dto.ProfileDto;
import com.aythee.datingapp.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController(value = "/api/v1")
public class ProfileControllerImpl implements ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileControllerImpl(ProfileService profileService) {
        this.profileService = profileService;
    }
    @Override
    public Map<String, Object> getProfile(Long id) {
        final Map<String, Object> result = new HashMap<>();
        final ProfileDto profile = profileService.findProfileById(id);
        result.put("profile", profile);
        return result;
    }

    @Override
    public Map<String, Object> createProfile(ProfileDto profileDto) {
        final Map<String, Object> result = new HashMap<>();
        final int created = profileService.createProfile(profileDto);
        result.put("created",created);
        return result;
    }
}
