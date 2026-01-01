package com.notification.ons.repository;

import com.notification.ons.domain.ErrorLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorLogRepository extends MongoRepository<ErrorLog, String> {
}
