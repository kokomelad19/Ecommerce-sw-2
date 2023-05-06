package com.ecommerce.api.users.interfaces;

import com.ecommerce.api.users.dto.input.UpdateProfileDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.models.Users;

public interface ProfileService {
    public UserDto getProfile(Users user);

    public UserDto updateProfile(Users user, UpdateProfileDto updateProfileDto);
}
