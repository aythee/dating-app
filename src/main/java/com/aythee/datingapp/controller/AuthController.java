package com.aythee.datingapp.controller;

import com.aythee.datingapp.dto.SignInDto;
import com.aythee.datingapp.dto.SignInRsDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {

    @PostMapping("/signUp")
    SignInRsDto singUp(@RequestBody @Valid SignInDto request);

    @PostMapping("/signIn")
    SignInRsDto signIn(@RequestBody @Valid SignInDto requst);


}
