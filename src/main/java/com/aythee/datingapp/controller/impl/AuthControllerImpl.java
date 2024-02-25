package com.aythee.datingapp.controller.impl;

import com.aythee.datingapp.controller.AuthController;
import com.aythee.datingapp.dto.SignInDto;
import com.aythee.datingapp.dto.SignInRsDto;
import com.aythee.datingapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {

    private final AuthenticationService authenticationService;
    @Override
    public SignInRsDto singUp(SignInDto request) {
        return authenticationService.signUp(request);
    }

    @Override
    public SignInRsDto signIn(SignInDto requst) {
        return authenticationService.signIn(requst);
    }
}
