package com.aythee.datingapp.repository.impl;

import com.aythee.datingapp.dto.ProfileDto;
import com.aythee.datingapp.repository.ProfileRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ProfileRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public ProfileDto getProfileById(Long id) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject("select * from profile where id = :id", namedParameters,
                new BeanPropertyRowMapper<>(ProfileDto.class));
    }

    @Override
    public Long createProfile(ProfileDto profileDto) {
        return null;
    }

    @Override
    public boolean updateProfile(ProfileDto profileDto) {
        return false;
    }
}
