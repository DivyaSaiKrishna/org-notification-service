package com.notification.ons.dto.preference;

public record QuietHoursRequest(
        boolean enabled,
        String start,
        String end
) {
}
