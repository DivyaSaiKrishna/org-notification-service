package com.notification.ons.domain;

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
public class ErrorLog {
    @Id
    private String id;

    private String source;          // USER_SERVICE / NOTIFICATION / PUBSUB / WORKER
    private String referenceId;     // userId / notificationId / deliveryId

    private String exceptionType;   // NullPointerException, IllegalStateException
    private String message;         // exception message
    private String stackTrace;      // trimmed stacktrace
    private String className;

    private Instant createdAt;
}
