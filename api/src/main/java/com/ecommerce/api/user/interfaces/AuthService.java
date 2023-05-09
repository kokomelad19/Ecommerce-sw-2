package com.ecommerce.api.user.interfaces;


import com.ecommerce.api.user.dto.input.LoginDto;
import com.ecommerce.api.user.dto.input.RegisterDto;
import com.ecommerce.api.user.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.user.dto.output.UserDto;

public interface AuthService {
    public AuthenticationResponseDto register(RegisterDto registerDto);

    public AuthenticationResponseDto login(LoginDto loginDto);

    public UserDto findUserByEmail(String email);
}
