package com.ecommerce.api.auth.dto.output;

import com.ecommerce.api.users.dto.output.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto extends UserDto {
    public AuthenticationResponseDto(UserDto userDto, String token) {
        super(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPhone(), userDto.getUserTypes());
        this.token = token;
    }

    private String token;
}
