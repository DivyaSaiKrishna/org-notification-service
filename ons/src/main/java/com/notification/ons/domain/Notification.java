package com.notification.ons.domain;

import com.notification.ons.enums.Channel;
import com.notification.ons.enums.NotificationStatus;
import com.notification.ons.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    private String notificationId;

    private String sourceSystem;          // incident, billing, governance
    private Priority priority;

    private List<String> userIds;         // resolved recipients
    private List<Channel> channels;       // EMAIL / SMS / APP

    private String templateId;
    private Map<String, Object> templateVariables;

    private NotificationStatus status;

    private Instant createdAt;
}
