package com.aythee.datingapp.service;

import com.aythee.datingapp.dto.SignInDto;
import com.aythee.datingapp.dto.SignInRsDto;
import com.aythee.datingapp.dto.UserDto;
import com.aythee.datingapp.service.impl.JwtServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserService userService;
    private final JwtServiceImpl jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService (UserService userService, JwtServiceImpl jwtService, PasswordEncoder passwordEncoder,
                                  AuthenticationManager authenticationManager) {
        this. userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public SignInRsDto signUp(SignInDto request) {
        UserDto user = UserDto.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userService.addUser(user);
        var jwt = jwtService.generateToken(user);
        return new SignInRsDto(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public SignInRsDto signIn(SignInDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getEmail());

        var jwt = jwtService.generateToken(user);
        return new SignInRsDto(jwt);
    }

}
