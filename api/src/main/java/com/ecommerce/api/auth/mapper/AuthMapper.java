package com.ecommerce.api.auth.mapper;

import com.ecommerce.api.auth.dto.RegisterDto;
import com.ecommerce.api.users.dto.UserDto;
import com.ecommerce.api.users.models.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    RegisterDto toRegisterDto(Users user);

    UserDto toUserDto(Users user);

    Users registerDtoToEntity(RegisterDto registerDto);
}
