package com.ecommerce.api.user.interfaces;

import com.ecommerce.api.user.dto.input.UpdateProfileDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.models.User;

public interface ProfileService {
    public UserDto getProfile(User user);

    public UserDto updateProfile(User user, UpdateProfileDto updateProfileDto);
}
