package com.aythee.datingapp.repository;

import com.aythee.datingapp.dto.ProfileDto;

public interface ProfileRepository {

    ProfileDto getProfileById(Long id);

    Long createProfile(ProfileDto profileDto);

    boolean updateProfile(ProfileDto profileDto);

}
