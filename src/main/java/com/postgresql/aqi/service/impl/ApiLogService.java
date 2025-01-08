package com.postgresql.aqi.service.impl;

import com.postgresql.aqi.entity.ApiLog;
import com.postgresql.aqi.repository.ApiLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ApiLogService {

    @Autowired
    private ApiLogRepository apiLogRepository;

    public void logApiRequest(String endpoint, Long userId, Long responseTime, int statusCode) {
        ApiLog log = new ApiLog();
        log.setEndpoint(endpoint);
        log.setUserId(userId);
        log.setRequestTimestamp(LocalDateTime.now());
        log.setResponseTime(responseTime);
        log.setStatusCode(statusCode);
        apiLogRepository.save(log);
    }
}