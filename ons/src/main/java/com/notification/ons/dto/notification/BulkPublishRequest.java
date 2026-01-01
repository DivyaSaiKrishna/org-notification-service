package com.notification.ons.dto.notification;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record BulkPublishRequest(
        @NotEmpty
        List<PublishNotificationRequest> notifications
) {
}
