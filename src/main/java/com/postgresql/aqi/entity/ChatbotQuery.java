package com.postgresql.aqi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ChatbotQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queryId;

    private String userQuery;
    private String botResponse;
    private LocalDateTime createdAt;

    public ChatbotQuery() {}

    public ChatbotQuery(String userQuery, String botResponse) {
        this.userQuery = userQuery;
        this.botResponse = botResponse;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(String userQuery) {
        this.userQuery = userQuery;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
