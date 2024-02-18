package com.aythee.datingapp.controller;

import com.aythee.datingapp.dto.ProfileDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ProfileController {

    @GetMapping("/getProfile")
    Map<String, Object> getProfile(@RequestParam Long id);

    @PostMapping("/createProfile")
    Map<String, Object> createProfile(@RequestBody ProfileDto profileDto);
}
