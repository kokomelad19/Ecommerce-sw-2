package com.ecommerce.api.user.mapper;

import com.ecommerce.api.user.dto.input.RegisterDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.models.User;
import com.ecommerce.api.user.models.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T21:55:39+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhone( user.getPhone() );
        userDto.setUserType( user.getUserType() );

        return userDto;
    }

    @Override
    public User registerDtoToEntity(RegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.firstName( registerDto.getFirstName() );
        user.lastName( registerDto.getLastName() );
        user.email( registerDto.getEmail() );
        user.password( registerDto.getPassword() );
        user.phone( registerDto.getPhone() );

        return user.build();
    }
}
