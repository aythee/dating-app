package com.aythee.datingapp.service;

import com.aythee.datingapp.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    String addUser(UserDto dto);

    String removeUser(UserDto dto);

    String updateUser(UserDto dto);

    UserDto getUserByEmail(String userName);

    UserDetailsService userDetailsService();
}
