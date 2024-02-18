package com.aythee.datingapp.dto;

import lombok.Data;

@Data
public class PreferenceDto {

    private Long preferenceId;
    private Long userId;
    private Integer minAge;
    private Integer maxAge;
    private String preferredLocation;
}
