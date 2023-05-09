package com.ecommerce.api.user.mapper;

import com.ecommerce.api.user.dto.input.UpdateProfileDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T00:42:35+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

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
    public User updateUserFromDto(UpdateProfileDto updateProfileDto, User user) {
        if ( updateProfileDto == null ) {
            return null;
        }

        user.setEmail( updateProfileDto.getEmail() == null ? user.getEmail() : updateProfileDto.getEmail() );
        user.setFirstName( updateProfileDto.getFirstName() == null ? user.getFirstName() : updateProfileDto.getFirstName() );
        user.setLastName( updateProfileDto.getLastName() == null ? user.getLastName() : updateProfileDto.getLastName() );
        user.setPhone( updateProfileDto.getPhone() == null ? user.getPhone() : updateProfileDto.getPhone() );
        user.setPassword( updateProfileDto.getPassword() == null ? user.getPassword() : updateProfileDto.getPassword() );

        return user;
    }
}
