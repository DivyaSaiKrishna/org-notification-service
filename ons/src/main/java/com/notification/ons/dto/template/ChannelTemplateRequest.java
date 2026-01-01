package com.notification.ons.dto.template;

public record ChannelTemplateRequest(
        String subject,   // EMAIL
        String body,      // EMAIL / SMS
        String title      // APP
) {
}
