package com.notification.ons.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.ons.domain.Notification;
import com.notification.ons.enums.Channel;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StreamPublisher {
    private final StringRedisTemplate redis;
    private final ObjectMapper mapper;

    public StreamPublisher(StringRedisTemplate redis, ObjectMapper mapper) {
        this.redis = redis;
        this.mapper = mapper;
    }

    public void publish(Notification notification) {

        for (Channel channel : notification.getChannels()) {
            try {
                redis.opsForStream().add(
                        stream(channel),
                        Map.of("data", mapper.writeValueAsString(notification))
                );
            } catch (Exception e) {
                throw new RuntimeException("Redis publish failed", e);
            }
        }
    }

    private String stream(Channel channel) {
        return switch (channel) {
            case EMAIL -> "ons:email";
            case SMS -> "ons:sms";
            case APP -> "ons:app";
        };
    }
}
