package com.notification.ons.dto.delivery;

import com.notification.ons.enums.Channel;
import com.notification.ons.enums.DeliveryStatus;

import java.time.Instant;

public record DeliveryResponse(
        String deliveryId,
        String userId,
        Channel channel,
        DeliveryStatus status,
        int attempts,
        Instant deliveredAt,
        String errorMessage
) {
}
