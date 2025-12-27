package com.notification.ons.dto.user;

import com.notification.ons.enums.Channel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record CreateUserRequest(
        @NotBlank
        String userId,

        @Email
        String email,

        String phoneNumber,

        String appToken,

        Set<Channel> preferredChannels,

        String timezone
) {
}
