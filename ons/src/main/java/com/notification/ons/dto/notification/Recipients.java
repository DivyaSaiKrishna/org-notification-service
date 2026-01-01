package com.notification.ons.dto.notification;

import java.util.List;

public record Recipients(
        List<String> userIds
) {
}
