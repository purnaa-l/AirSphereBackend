package com.postgresql.aqi.repository;


import com.postgresql.aqi.entity.ChatbotQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotQueryRepository extends JpaRepository<ChatbotQuery, Long> {
}
