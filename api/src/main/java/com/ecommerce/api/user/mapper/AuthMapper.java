package com.ecommerce.api.user.mapper;

import com.ecommerce.api.user.dto.input.RegisterDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AuthMapper {


    UserDto toUserDto(User user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", ignore = true)
    @Mapping(target = "cart", ignore = true)
    User registerDtoToEntity(RegisterDto registerDto);
}
