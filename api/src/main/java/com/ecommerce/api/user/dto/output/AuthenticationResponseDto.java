package com.ecommerce.api.user.dto.output;

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
        super(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPhone(), userDto.getUserType());
        this.token = token;
    }

    private String token;
}
