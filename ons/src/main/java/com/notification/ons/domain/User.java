package com.notification.ons.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;

    private String email;          // for EMAIL
    private String phoneNumber;    // for SMS
    private String appToken;       // for APP (FCM / Web)

   // private Set<Channel> preferredChannels;

    private String timezone;
    private boolean active;

    private Instant createdAt;
    private Instant updatedAt;
}
