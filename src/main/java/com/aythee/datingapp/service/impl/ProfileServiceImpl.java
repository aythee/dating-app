package com.aythee.datingapp.service.impl;

import com.aythee.datingapp.dto.ProfileDto;
import com.aythee.datingapp.repository.ProfileRepository;
import com.aythee.datingapp.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {


    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileDto findProfileById(Long id) {
        return profileRepository.getProfileById(id);
    }
}
