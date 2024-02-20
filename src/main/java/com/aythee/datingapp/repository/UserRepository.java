package com.aythee.datingapp.repository;

import com.aythee.datingapp.dto.UserDto;

public interface UserRepository {

    boolean createUser(UserDto dto);

    boolean deleteUser(UserDto dto);

    boolean updateUser(UserDto dto);
}
