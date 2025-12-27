package com.notification.ons.repository;

import com.notification.ons.domain.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<Delivery, String> {
}
