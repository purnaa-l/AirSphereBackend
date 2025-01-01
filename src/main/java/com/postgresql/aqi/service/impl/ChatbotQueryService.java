package com.postgresql.aqi.service.impl;

import com.postgresql.aqi.entity.ChatbotQuery;
import com.postgresql.aqi.repository.ChatbotQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotQueryService {

    @Autowired
    private ChatbotQueryRepository chatbotQueryRepository;

    // Method to save the query and response
    public void saveChatbotQuery(String userQuery, String botResponse) {
        ChatbotQuery chatbotQuery = new ChatbotQuery(userQuery, botResponse);
        chatbotQueryRepository.save(chatbotQuery);
    }
}
