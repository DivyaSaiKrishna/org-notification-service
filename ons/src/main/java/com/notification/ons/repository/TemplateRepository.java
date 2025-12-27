package com.notification.ons.repository;

import com.notification.ons.domain.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemplateRepository extends MongoRepository<Template, String> {
}
