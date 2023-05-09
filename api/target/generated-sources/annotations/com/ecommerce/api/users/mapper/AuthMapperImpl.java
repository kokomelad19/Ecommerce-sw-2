package com.ecommerce.api.users.mapper;

import com.ecommerce.api.users.dto.input.RegisterDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.models.Users;
import com.ecommerce.api.users.models.Users.UsersBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T21:09:38+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

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
        userDto.setUserType( user.getUserType() );

        return userDto;
    }

    @Override
    public Users registerDtoToEntity(RegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        UsersBuilder users = Users.builder();

        users.firstName( registerDto.getFirstName() );
        users.lastName( registerDto.getLastName() );
        users.email( registerDto.getEmail() );
        users.password( registerDto.getPassword() );
        users.phone( registerDto.getPhone() );

        return users.build();
    }
}
