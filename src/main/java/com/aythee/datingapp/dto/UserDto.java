package com.aythee.datingapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String location;
    //todo rework name of field or getter
    private LocalDateTime created_at;

}
