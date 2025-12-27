package com.notification.ons.enums;

public enum NotificationStatus {
    QUEUED,         // accepted by API, published to Pub/Sub
    PROCESSING,     // deliveries in progress
    DELIVERED,      // all required deliveries succeeded
    PARTIAL,        // some channels/users failed
    FAILED,         // all deliveries failed
    CANCELLED       // cancelled before delivery
}
