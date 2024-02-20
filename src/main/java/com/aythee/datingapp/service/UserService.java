package com.aythee.datingapp.service;

import com.aythee.datingapp.dto.UserDto;

public interface UserService {

    String addUser(UserDto dto);

    String removeUser(UserDto dto);

    String updateUser(UserDto dto);
}
