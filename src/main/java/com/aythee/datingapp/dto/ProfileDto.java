package com.aythee.datingapp.dto;

import lombok.Data;

@Data
public class ProfileDto {

    private Long id;
    private Long userId;
    private String profilePhoto;
    private String bio;
}
