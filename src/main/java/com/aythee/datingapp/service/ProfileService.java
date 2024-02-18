package com.aythee.datingapp.service;

import com.aythee.datingapp.dto.ProfileDto;

public interface ProfileService {

    ProfileDto findProfileById(Long id);

    int createProfile(ProfileDto profileDto);


}
