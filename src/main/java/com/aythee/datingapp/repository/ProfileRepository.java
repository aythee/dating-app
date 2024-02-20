package com.aythee.datingapp.repository;

import com.aythee.datingapp.dto.ProfileDto;

public interface ProfileRepository {

    ProfileDto getProfileById(Long id);

    int createProfile(ProfileDto profileDto);

    boolean updateProfile(Long id, ProfileDto profileDto);

}
