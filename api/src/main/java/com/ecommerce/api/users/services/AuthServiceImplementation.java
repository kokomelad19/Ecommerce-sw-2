package com.ecommerce.api.users.services;


import com.ecommerce.api.users.dto.input.LoginDto;
import com.ecommerce.api.users.dto.input.RegisterDto;
import com.ecommerce.api.users.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.interfaces.AuthService;
import com.ecommerce.api.users.mapper.AuthMapper;
import com.ecommerce.api.users.models.Users;
import com.ecommerce.api.users.repository.UsersRepository;
import com.ecommerce.api.users.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public AuthenticationResponseDto login(LoginDto loginDto) {
        Users user = usersRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password"));

        boolean isValid = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
        if (!isValid) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password");

        // Generate token
        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDto(authMapper.toUserDto(user) , token);
    }

    public UserDto findUserByEmail(String email) {
        return authMapper.toUserDto(usersRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User is not exist")));
    }

}
