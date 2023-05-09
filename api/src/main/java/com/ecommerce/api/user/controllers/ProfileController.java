package com.ecommerce.api.user.controllers;

import com.ecommerce.api.user.dto.input.UpdateProfileDto;
import com.ecommerce.api.user.dto.output.UserDto;
import com.ecommerce.api.user.interfaces.ProfileService;
import com.ecommerce.api.user.models.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/my-profile")
    public ResponseEntity<UserDto> getProfile(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok(profileService.getProfile(user));
    }

    @PatchMapping("/my-profile")
    public ResponseEntity<UserDto> updateProfile(@AuthenticationPrincipal User user, @RequestBody @Valid UpdateProfileDto updateProfileDto) {
        return ResponseEntity.ok(profileService.updateProfile(user, updateProfileDto));
    }
}
