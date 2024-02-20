package com.aythee.datingapp.repository.impl;

import com.aythee.datingapp.dto.UserDto;
import com.aythee.datingapp.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Base64;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public boolean createUser(UserDto dto) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("username", dto.getUsername())
                .addValue("email", dto.getEmail())
                .addValue("password",
                        Base64.getEncoder().encodeToString(dto.getPassword().getBytes()))
                .addValue("gender", dto.getGender())
                .addValue("age",dto.getAge())
                .addValue("location",dto.getLocation())
                .addValue("created_at",dto.getCreated_at());
        return namedParameterJdbcTemplate.update("insert into users (username, email, password, age, gender, location, created_at) values(:username, :email, :password, " +
                ":age, :gender, :location, :created_at)", namedParameters) == 1;
    }

    @Override
    public boolean deleteUser(UserDto dto) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", dto.getId());
        return namedParameterJdbcTemplate.update("delete * from users where id = :id", namedParameters) == 1;
    }

    @Override
    public boolean updateUser(UserDto dto) {
        return false;
    }


}
