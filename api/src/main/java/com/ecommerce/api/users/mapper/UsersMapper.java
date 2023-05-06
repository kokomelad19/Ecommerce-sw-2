package com.ecommerce.api.users.mapper;

import com.ecommerce.api.users.dto.input.UpdateProfileDto;
import com.ecommerce.api.users.dto.output.UserDto;
import com.ecommerce.api.users.models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UserDto toUserDto(Users user);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", ignore = true)
    @Mapping(target = "email", expression = "java(updateProfileDto.getEmail() == null ? user.getEmail() : updateProfileDto.getEmail())")
    @Mapping(target = "firstName", expression = "java(updateProfileDto.getFirstName() == null ? user.getFirstName() : updateProfileDto.getFirstName())")
    @Mapping(target = "lastName", expression = "java(updateProfileDto.getLastName() == null ? user.getLastName() : updateProfileDto.getLastName())")
    @Mapping(target = "phone", expression = "java(updateProfileDto.getPhone() == null ? user.getPhone() : updateProfileDto.getPhone())")
    @Mapping(target = "password", expression = "java(updateProfileDto.getPassword() == null ? user.getPassword() : updateProfileDto.getPassword())")
    Users updateUserFromDto(UpdateProfileDto updateProfileDto, @MappingTarget Users user);

}
