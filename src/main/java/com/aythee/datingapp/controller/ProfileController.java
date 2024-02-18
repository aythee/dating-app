package com.aythee.datingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ProfileController {

    @GetMapping("/getProfile")
    Map<String, Object> getProfile(@RequestParam Long id);
}
