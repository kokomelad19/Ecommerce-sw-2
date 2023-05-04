package com.ecommerce.api.auth.services;

import com.ecommerce.api.auth.dto.RegisterDto;
import com.ecommerce.api.auth.interfaces.AuthService;
import com.ecommerce.api.auth.mapper.AuthMapper;
import com.ecommerce.api.users.dto.UserDto;
import com.ecommerce.api.users.models.Users;
import com.ecommerce.api.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {


    private final UsersRepository usersRepository;

    private final AuthMapper authMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserDto register(RegisterDto registerDto) {
        // encrypt password
        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // map dto to user entity
        Users user = authMapper.registerDtoToEntity(registerDto);
        // save user and return dto
        return authMapper.toUserDto(usersRepository.save(user));
    }

}
