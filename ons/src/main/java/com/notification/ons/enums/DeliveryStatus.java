package com.notification.ons.enums;

public enum DeliveryStatus {
    PENDING,        // waiting to be sent
    SENT,           // sent to provider
    DELIVERED,      // confirmed delivered
    FAILED,         // failed after retries
    RETRYING        // retry in progress
}
