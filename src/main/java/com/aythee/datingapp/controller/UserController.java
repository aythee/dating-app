package com.aythee.datingapp.controller;

import com.aythee.datingapp.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UserController {

    @PostMapping("/createUser")
    Map<String, Object> addUser(@RequestBody UserDto dto);

    Map<String, Object> updateUser(@RequestBody UserDto dto);

    Map<String, Object> removeUser(@RequestBody UserDto dto);
}
