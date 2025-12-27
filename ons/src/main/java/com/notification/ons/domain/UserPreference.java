package com.notification.ons.domain;

import com.notification.ons.enums.Channel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPreference {
    @Id
    private String userId;

    private Map<Channel, ChannelPreference> channelPreferences;

    private QuietHours quietHours;

    private Instant updatedAt;
}
