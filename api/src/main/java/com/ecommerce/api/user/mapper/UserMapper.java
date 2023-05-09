package com.ecommerce.api.user.mapper;

import com.ecommerce.api.user.dto.input.UpdateProfileDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", ignore = true)
    @Mapping(target = "cart", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "email", expression = "java(updateProfileDto.getEmail() == null ? user.getEmail() : updateProfileDto.getEmail())")
    @Mapping(target = "firstName", expression = "java(updateProfileDto.getFirstName() == null ? user.getFirstName() : updateProfileDto.getFirstName())")
    @Mapping(target = "lastName", expression = "java(updateProfileDto.getLastName() == null ? user.getLastName() : updateProfileDto.getLastName())")
    @Mapping(target = "phone", expression = "java(updateProfileDto.getPhone() == null ? user.getPhone() : updateProfileDto.getPhone())")
    @Mapping(target = "password", expression = "java(updateProfileDto.getPassword() == null ? user.getPassword() : updateProfileDto.getPassword())")
    User updateUserFromDto(UpdateProfileDto updateProfileDto, @MappingTarget User user);

}
