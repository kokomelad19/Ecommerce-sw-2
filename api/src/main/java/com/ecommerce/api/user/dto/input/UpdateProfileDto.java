package com.ecommerce.api.user.dto.input;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileDto {

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    @Email(message = "Invalid email format")
    private String email;

    @Nullable
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;


    @Nullable
    private String phone;

}
