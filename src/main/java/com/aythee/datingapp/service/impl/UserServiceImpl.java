package com.aythee.datingapp.service.impl;

import com.aythee.datingapp.dto.UserDto;
import com.aythee.datingapp.repository.UserRepository;
import com.aythee.datingapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final static String CREATED_OK = "User successfully created!";
    private final static String DELETED_OK = "User successfully deleted!";
    private final static String UPDATED_OK = "User successfully updated!";


    private final static String CREATED_ERR = "Cannot create user! Reason: %s.";
    private final static String DELETED_ERR = "Cannot delete user! Reason: %s.";
    private final static String UPDATED_ERR = "Cannot update user! Reason: %s.";

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public String addUser(UserDto dto) {
        try {
            userRepository.createUser(dto);
        } catch (DataAccessException e) {
            final String errorMessage = String.format(CREATED_ERR, e);
            log.error(errorMessage, e);
            return errorMessage;
        }
        return CREATED_OK;
    }

    @Override
    public String removeUser(UserDto dto) {
        return null;
    }

    @Override
    public String updateUser(UserDto dto) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserDto getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(username);
    }

    public UserDetailsService userDetailsService() {
        return this::getUserByEmail;
    }
}
