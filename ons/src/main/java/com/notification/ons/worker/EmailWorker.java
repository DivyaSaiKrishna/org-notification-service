package com.notification.ons.worker;

import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailWorker {
    private static final String STREAM = "ons:email";
    private static final String GROUP = "email-group";
    private static final String CONSUMER = "email-1";

    private final StringRedisTemplate redis;

    public EmailWorker(StringRedisTemplate redis) {
        this.redis = redis;
        createGroupIfMissing();
    }

    private void createGroupIfMissing() {
        try {
            redis.opsForStream().createGroup(STREAM, GROUP);
        } catch (Exception ignored) {}
    }

    @Scheduled(fixedDelay = 1000)
    public void consume() {

        List<MapRecord<String, Object, Object>> records =
                redis.opsForStream().read(
                        Consumer.from(GROUP, CONSUMER),
                        StreamReadOptions.empty().count(10),
                        StreamOffset.create(STREAM, ReadOffset.lastConsumed())
                );

        if (records == null) return;

        for (MapRecord<String, Object, Object> r : records) {
            try {
                // send email here

                redis.opsForStream()
                        .acknowledge(STREAM, GROUP, r.getId());

            } catch (Exception e) {
                // no ACK → Redis will retry
            }
        }
    }
}
