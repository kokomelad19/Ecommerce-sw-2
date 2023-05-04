package com.ecommerce.api.auth.controllers;

import com.ecommerce.api.auth.dto.RegisterDto;
import com.ecommerce.api.auth.interfaces.AuthService;
import com.ecommerce.api.users.dto.UserDto;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto) {
        return  ResponseEntity.ok(authService.register(registerDto));
    }
}
