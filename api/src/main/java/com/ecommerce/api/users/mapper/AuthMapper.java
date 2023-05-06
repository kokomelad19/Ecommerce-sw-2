package com.ecommerce.api.users.mapper;

import com.ecommerce.api.users.dto.input.RegisterDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AuthMapper {


    UserDto toUserDto(Users user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", ignore = true)
    Users registerDtoToEntity(RegisterDto registerDto);
}
