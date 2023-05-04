package com.ecommerce.api.auth.services;

import com.ecommerce.api.auth.dto.input.RegisterDto;
import com.ecommerce.api.auth.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.auth.interfaces.AuthService;
import com.ecommerce.api.auth.mapper.AuthMapper;
import com.ecommerce.api.auth.security.JwtService;
import com.ecommerce.api.users.dto.UserDto;
import com.ecommerce.api.users.models.Users;
import com.ecommerce.api.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {


    private final UsersRepository usersRepository;

    private final AuthMapper authMapper;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponseDto register(RegisterDto registerDto) {
        // encrypt password
        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // map dto to user entity
        Users user = (usersRepository.save(authMapper.registerDtoToEntity(registerDto)));

        // Generate token
        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDto(authMapper.toUserDto(user), token);
    }


    public UserDto findUserByEmail(String email) {
        return authMapper.toUserDto(usersRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User is not exist")));
    }

}
