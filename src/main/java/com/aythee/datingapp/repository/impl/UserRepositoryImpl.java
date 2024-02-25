package com.aythee.datingapp.repository.impl;

import com.aythee.datingapp.dto.UserDto;
import com.aythee.datingapp.repository.UserRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
                .addValue("created_at", LocalDateTime.now());
        return namedParameterJdbcTemplate.update("insert into users (email, password, created_at) values(:email, :password, " +
                ":created_at)", namedParameters) == 1;
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

    @Override
    public UserDto findByEmail(String email) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("email", email);
        return namedParameterJdbcTemplate.queryForObject("select * from users where email = :email", namedParameters, new BeanPropertyRowMapper<>(UserDto.class));
    }


}
