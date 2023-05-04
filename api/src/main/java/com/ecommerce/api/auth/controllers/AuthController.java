package com.ecommerce.api.auth.controllers;

import com.ecommerce.api.auth.dto.input.RegisterDto;
import com.ecommerce.api.auth.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.auth.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity(authService.register(registerDto) ,  HttpStatus.CREATED);
    }
}
