package com.ecommerce.api.auth.interfaces;

import com.ecommerce.api.auth.dto.RegisterDto;
import com.ecommerce.api.users.dto.UserDto;

public interface AuthService {
    public abstract UserDto register(RegisterDto registerDto);
}
