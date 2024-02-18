package com.aythee.datingapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;
    private String userName;
    private String email;
    private Integer age;
    private String gender;
    private String location;
    private LocalDateTime created;

}
