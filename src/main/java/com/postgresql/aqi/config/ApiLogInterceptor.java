package com.postgresql.aqi.config;

import com.postgresql.aqi.service.impl.ApiLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiLogInterceptor implements HandlerInterceptor {

    @Autowired
    private ApiLogService apiLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        Long endTime = System.currentTimeMillis();
        String endpoint = request.getRequestURI();
        Long userId = null;  // Retrieve user ID from session or token if applicable
        Long responseTime = endTime - startTime;
        int statusCode = response.getStatus();

        apiLogService.logApiRequest(endpoint, userId, responseTime, statusCode);
    }
}

