package com.postgresql.aqi.controller;

import com.postgresql.aqi.service.impl.ChatbotService;
import com.postgresql.aqi.service.impl.ChatbotQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/aqi/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @Autowired
    private ChatbotQueryService chatbotQueryService;
    @CrossOrigin(origins = "http://localhost:5173") // Allow requests from frontend
    @PostMapping("/query")
    public String getChatResponse(@RequestBody Map<String, String> payload) {
        String userMessage = payload.get("message");  // Extract message from the payload
        String botResponse = chatbotService.getChatResponse(userMessage);
        chatbotQueryService.saveChatbotQuery(userMessage, botResponse);
        return botResponse;
    }

}
