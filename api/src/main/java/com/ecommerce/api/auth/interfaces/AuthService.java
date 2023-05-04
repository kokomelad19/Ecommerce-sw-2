package com.ecommerce.api.auth.interfaces;

import com.ecommerce.api.auth.dto.input.RegisterDto;
import com.ecommerce.api.auth.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.users.dto.UserDto;

import java.util.Optional;

public interface AuthService {
    public AuthenticationResponseDto register(RegisterDto registerDto);

    public UserDto findUserByEmail(String email);
}
