package com.notification.ons.dto.preference;

import com.notification.ons.enums.Channel;

import java.util.Map;

public record UpdatePreferenceRequest(
        Map<Channel, ChannelPreferenceRequest> channels,
        QuietHoursRequest quietHours
) {
}
