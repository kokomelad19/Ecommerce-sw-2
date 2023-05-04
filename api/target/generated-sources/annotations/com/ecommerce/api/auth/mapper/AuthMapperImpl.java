package com.ecommerce.api.auth.mapper;

import com.ecommerce.api.auth.dto.RegisterDto;
import com.ecommerce.api.users.dto.UserDto;
import com.ecommerce.api.users.models.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-02T23:11:57+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public RegisterDto toRegisterDto(Users user) {
        if ( user == null ) {
            return null;
        }

        RegisterDto registerDto = new RegisterDto();

        registerDto.setFirstName( user.getFirstName() );
        registerDto.setLastName( user.getLastName() );
        registerDto.setEmail( user.getEmail() );
        registerDto.setPassword( user.getPassword() );
        registerDto.setPhone( user.getPhone() );

        return registerDto;
    }

    @Override
    public UserDto toUserDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhone( user.getPhone() );

        return userDto;
    }

    @Override
    public Users registerDtoToEntity(RegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setFirstName( registerDto.getFirstName() );
        users.setLastName( registerDto.getLastName() );
        users.setEmail( registerDto.getEmail() );
        users.setPassword( registerDto.getPassword() );
        users.setPhone( registerDto.getPhone() );

        return users;
    }
}
