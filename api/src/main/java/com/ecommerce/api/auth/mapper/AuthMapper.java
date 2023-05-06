package com.ecommerce.api.auth.mapper;

import com.ecommerce.api.auth.dto.input.RegisterDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.models.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    UserDto toUserDto(Users user);


    Users registerDtoToEntity(RegisterDto registerDto);
}
