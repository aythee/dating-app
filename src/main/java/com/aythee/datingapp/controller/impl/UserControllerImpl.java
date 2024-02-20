package com.aythee.datingapp.controller.impl;

import com.aythee.datingapp.controller.UserController;
import com.aythee.datingapp.dto.UserDto;
import com.aythee.datingapp.service.UserService;
import com.aythee.datingapp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }
    @Override
    public Map<String, Object> addUser(UserDto dto) {
        final Map<String, Object> result = new HashMap<>();
        final String status = userService.addUser(dto);
        result.put("status", status);
        return result;
    }

    @Override
    public Map<String, Object> updateUser(UserDto dto) {
        return null;
    }

    @Override
    public Map<String, Object> removeUser(UserDto dto) {
        return null;
    }
}
