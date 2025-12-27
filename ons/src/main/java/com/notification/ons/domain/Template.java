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
public class Template {
    @Id
    private String templateId;

    private Map<Channel, ChannelTemplate> channelTemplates;

    private boolean active;
    private int version;

    private Instant createdAt;
    private Instant updatedAt;
}
