package com.notification.ons.domain;

import com.notification.ons.enums.Channel;
import com.notification.ons.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {
    @Id
    private String deliveryId;

    private String notificationId;
    private String userId;

    private Channel channel;

    private DeliveryStatus status;
    private int attempts;

    private String errorMessage;

    private Instant deliveredAt;
    private Instant createdAt;
}
