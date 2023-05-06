package com.ecommerce.api.users.interfaces;


import com.ecommerce.api.users.dto.input.LoginDto;
import com.ecommerce.api.users.dto.input.RegisterDto;
import com.ecommerce.api.users.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.users.dto.output.UserDto;

public interface AuthService {
    public AuthenticationResponseDto register(RegisterDto registerDto);

    public AuthenticationResponseDto login(LoginDto loginDto);

    public UserDto findUserByEmail(String email);
}
