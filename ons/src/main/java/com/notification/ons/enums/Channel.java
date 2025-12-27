package com.notification.ons.enums;

public enum Channel {
    EMAIL,   // Email notifications (SendGrid / SMTP)
    SMS,     // SMS notifications (Twilio / SNS)
    APP      // App / Push notifications (FCM / Web / App Inbox)
}
