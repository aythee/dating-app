package com.aythee.datingapp;

import com.aythee.datingapp.dto.ProfileDto;
import com.aythee.datingapp.repository.impl.ProfileRepositoryImpl;
import com.aythee.datingapp.service.impl.ProfileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceImplTest {

    @Mock
    private ProfileRepositoryImpl profileRepository;

    @InjectMocks
    private ProfileServiceImpl profileService;
    private ProfileDto profile;

    @BeforeEach
    void setUp() {
        this.profile = new ProfileDto();
        profile.setId(1L);
        profile.setUserId(123L);
        profile.setBio("somebio information");
        profile.setProfilePhoto("profilePicture.jpg");
    }
    @Test
    void findProfileById_ById1_returnsCorrectDto() {
        when(profileRepository.getProfileById(1L)).thenReturn(profile);
        Long userId =  profileService.findProfileById(1L).getUserId();
        assertEquals(123L, userId);
    }
}
