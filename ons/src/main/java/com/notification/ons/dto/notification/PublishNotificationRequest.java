package com.notification.ons.dto.notification;

import com.notification.ons.enums.Channel;
import com.notification.ons.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

public record PublishNotificationRequest(
        @NotBlank
        String sourceSystem,

        @NotNull
        Priority priority,

        @NotEmpty
        List<Channel> channels,

        @NotNull
        Recipients recipients,

        @NotBlank
        String templateId,

        Map<String, Object> templateVariables
) {
}
