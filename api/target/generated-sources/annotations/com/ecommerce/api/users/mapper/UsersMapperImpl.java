package com.ecommerce.api.users.mapper;

import com.ecommerce.api.users.dto.input.UpdateProfileDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.models.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T00:53:17+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

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
    public Users updateUserFromDto(UpdateProfileDto updateProfileDto, Users user) {
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
