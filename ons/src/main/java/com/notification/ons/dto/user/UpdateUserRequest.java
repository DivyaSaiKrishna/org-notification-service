package com.notification.ons.dto.user;

import com.notification.ons.enums.Channel;

import java.util.Set;

public record UpdateUserRequest(
        String userId,
        String email,
        String phoneNumber,
        String appToken,
        Set<Channel> preferredChannels
) {
}
