package com.postgresql.aqi.controller;

import com.postgresql.aqi.service.impl.ApiLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/apilog")
public class ApiController {

    @Autowired
    private ApiLogService apiLogService;

    @GetMapping("/example")
    public String exampleEndpoint(HttpServletRequest request) {
        long startTime = System.currentTimeMillis(); // Record start time
        String response;

        try {
            // Business logic goes here
            response = "Success";
            return response;
        } finally {
            long responseTime = System.currentTimeMillis() - startTime; // Calculate response time
            int statusCode = 200; // Default status; modify if necessary
            String endpoint = request.getRequestURI(); // Get the endpoint URI
            Long userId = null; // Optional: Extract from session or token

            // Log the API call details
            apiLogService.logApiRequest(endpoint, userId, responseTime, statusCode);
        }
    }
}
