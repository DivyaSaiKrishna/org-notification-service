package com.notification.ons.service;

import com.notification.ons.domain.ErrorLog;
import com.notification.ons.repository.ErrorLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    //create service
    public void logException(
            String source,
            String refernceId,
            Exception exception
    ){
        ErrorLog errorLog = ErrorLog.builder().
                source(source).
                className(String.valueOf(exception.getClass())).
                referenceId(refernceId).
                stackTrace(String.valueOf(exception.getStackTrace())).
                exceptionType(exception.getClass().getSimpleName()).
                message(exception.getMessage()).
                createdAt(Instant.now()).
                build();
        errorLogRepository.save(errorLog);
    }
}
