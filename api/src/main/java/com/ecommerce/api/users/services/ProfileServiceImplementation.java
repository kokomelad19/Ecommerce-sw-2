package com.ecommerce.api.users.services;

import com.ecommerce.api.users.dto.input.UpdateProfileDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.interfaces.ProfileService;
import com.ecommerce.api.users.mapper.UsersMapper;
import com.ecommerce.api.users.models.Users;
import com.ecommerce.api.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImplementation implements ProfileService {
    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public UserDto getProfile(Users user) {
        return usersMapper.toUserDto(user);
    }


    public UserDto updateProfile(Users user, UpdateProfileDto updateProfileDto) {
        // if new password then encrypt it
        if (updateProfileDto.getPassword() != null) {
            updateProfileDto.setPassword(passwordEncoder.encode(updateProfileDto.getPassword()));
        }

        user = usersMapper.updateUserFromDto(updateProfileDto, user);

        usersRepository.save(user);

        return usersMapper.toUserDto(user);
    }
}
