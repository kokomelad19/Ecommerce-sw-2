package com.ecommerce.api.user.dto.output;

import com.ecommerce.api.user.enums.UserType;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String phone;

    private UserType userType = UserType.USER;


}
