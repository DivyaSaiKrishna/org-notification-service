package com.notification.ons.dto.template;

import com.notification.ons.enums.Channel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

public record CreateTemplateRequest(
        @NotBlank
        String templateId,

        @NotEmpty
        Map<Channel, ChannelTemplateRequest> channels
) {
}
