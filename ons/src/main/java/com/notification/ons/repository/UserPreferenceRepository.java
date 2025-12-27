package com.notification.ons.repository;

import com.notification.ons.domain.UserPreference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPreferenceRepository extends MongoRepository<UserPreference, String> {
}
