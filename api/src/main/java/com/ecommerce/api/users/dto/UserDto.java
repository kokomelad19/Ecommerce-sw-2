package com.ecommerce.api.users.dto;

import com.ecommerce.api.users.enums.UserTypes;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    private Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String phone;

    private UserTypes userTypes = UserTypes.USER;


}
