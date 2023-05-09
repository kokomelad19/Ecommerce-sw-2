package com.ecommerce.api.user.services;

import com.ecommerce.api.user.dto.input.UpdateProfileDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.interfaces.ProfileService;
import com.ecommerce.api.user.mapper.UserMapper;
import com.ecommerce.api.user.models.User;
import com.ecommerce.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImplementation implements ProfileService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDto getProfile(User user) {
        return userMapper.toUserDto(user);
    }


    public UserDto updateProfile(User user, UpdateProfileDto updateProfileDto) {
        // if new password then encrypt it
        if (updateProfileDto.getPassword() != null) {
            updateProfileDto.setPassword(passwordEncoder.encode(updateProfileDto.getPassword()));
        }

        user = userMapper.updateUserFromDto(updateProfileDto, user);

        userRepository.save(user);

        return userMapper.toUserDto(user);
    }
}
