package com.ecommerce.api.user.services;


import com.ecommerce.api.errorHandling.RecordNotFoundException;
import com.ecommerce.api.user.dto.input.LoginDto;
import com.ecommerce.api.user.dto.input.RegisterDto;
import com.ecommerce.api.user.dto.output.AuthenticationResponseDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.interfaces.AuthService;
import com.ecommerce.api.user.mapper.AuthMapper;
import com.ecommerce.api.user.models.User;
import com.ecommerce.api.user.repository.UserRepository;
import com.ecommerce.api.user.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {


    private final UserRepository userRepository;

    private final AuthMapper authMapper;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponseDto register(RegisterDto registerDto) {
        // encrypt password
        registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // map dto to user entity
        User user = (userRepository.save(authMapper.registerDtoToEntity(registerDto)));

        // Generate token
        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDto(authMapper.toUserDto(user), token);
    }

    public AuthenticationResponseDto login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password"));

        boolean isValid = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
        if (!isValid) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email or password");

        // Generate token
        String token = jwtService.generateToken(user);

        return new AuthenticationResponseDto(authMapper.toUserDto(user) , token);
    }

    public UserDto findUserByEmail(String email) {
        return authMapper.toUserDto(userRepository.findByEmail(email).orElseThrow(() -> new RecordNotFoundException("User is not exist")));
    }

}
