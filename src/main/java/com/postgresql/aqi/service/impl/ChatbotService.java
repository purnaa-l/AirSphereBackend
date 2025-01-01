package com.postgresql.aqi.service.impl;

import com.postgresql.aqi.model.AQIInfo;
import com.postgresql.aqi.model.AirSphereInfo;
import com.postgresql.aqi.model.BreathingProblemInfo;
import com.postgresql.aqi.model.EmergencyContacts;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String getChatResponse(String userMessage) {
        userMessage = userMessage.toLowerCase().trim();

        // Logging to check the message the chatbot receives
        System.out.println("User Message: " + userMessage);

        // Handling greeting messages
        if (isGreeting(userMessage)) {
            return "Hello! How can I assist you today? Feel free to ask about AQI, AirSphere services, or health tips.";
        }

        // Handling thanks messages
        if (isThanks(userMessage)) {
            return "You're welcome! Let me know if you need more help. Stay safe!";
        }

        // Handling farewell messages
        if (isFarewell(userMessage)) {
            return "Goodbye! Stay safe and take care of your health!";
        }

        // Handling query about AirSphere services
        if (isAboutAirSphere(userMessage)) {
            return AirSphereInfo.getAirSphereInfo();
        }

        // Handling specific query for health tips
        if (userMessage.contains("health tips") || userMessage.contains("health advice")) {
            return "Here are some health tips for you:\n- Avoid outdoor activities when AQI is high.\n- Stay hydrated and wear a mask if you need to go outside.\n- Use air purifiers inside your home to reduce indoor pollution.\n- If you experience any breathing issues, seek medical help immediately.";
        }

        // Handling activities query for AQI value
        if (userMessage.contains("activities for aqi")) {
            return handleActivitiesQuery(userMessage);
        }

        // Handling breathing difficulty advice
        if (userMessage.contains("breathing difficulty") || userMessage.contains("difficulty breathing")) {
            return BreathingProblemInfo.getBreathingProblemAdvice();
        }

        // Handling query about emergency contacts
        if (userMessage.contains("emergency contacts") || userMessage.contains("toll-free numbers") || userMessage.contains("emergency")) {
            return EmergencyContacts.getEmergencyContacts();
        }

        // Handling query about AQI levels
        if (userMessage.contains("what is aqi") || userMessage.contains("aqi level")) {
            return "AQI (Air Quality Index) is a scale used to measure the quality of air. It ranges from 0 to 500, with higher values indicating poorer air quality.";
        }

        // Handling query about explaining AQI to a 5-year-old
        if (userMessage.contains("explain aqi to me")) {
            return "AQI is like a score that tells us how clean or dirty the air is. If the score is low, the air is good and it's easy to breathe. If the score is high, the air is bad, and it might make it harder to breathe, especially for people with asthma. It's like checking if the air is safe to play outside or if you need to stay inside!";
        }

        // Default fallback message
        return "I'm sorry, I didn't understand that. Can you ask about AQI levels, AirSphere services, or emergency contacts?";
    }

    // Helper method to check if message is a greeting
    private boolean isGreeting(String message) {
        return message.contains("hello") || message.contains("hi") || message.contains("hey");
    }

    // Helper method to check if message is a thank you
    private boolean isThanks(String message) {
        return message.contains("thank you") || message.contains("thanks");
    }

    // Helper method to check if message is a farewell
    private boolean isFarewell(String message) {
        return message.contains("bye") || message.contains("goodbye");
    }

    // Helper method to check if message is about AirSphere
    private boolean isAboutAirSphere(String message) {
        return message.contains("what is airsphere") || message.contains("airsphere services") || message.contains("airsphere");
    }

    // Helper method to check if message is about health tips
    private boolean isHealthTips(String message) {
        return message.contains("health tips") || message.contains("health advice");
    }

    // Helper method to check if message is about breathing problems
    private boolean isBreathingProblems(String message) {
        return message.contains("breathing problems") || message.contains("difficulty breathing");
    }

    // Handling activities query based on AQI value
    private String handleActivitiesQuery(String message) {
        String[] words = message.split(" ");
        for (String word : words) {
            try {
                // Check if the word is an integer (AQI value)
                int aqiValue = Integer.parseInt(word);
                return AQIInfo.getRecommendedActivities(aqiValue);  // Get activities based on AQI value
            } catch (NumberFormatException e) {
                // Ignore and continue if the word is not an AQI value
            }
        }
        return "Please provide an AQI value to recommend specific activities. Example: 'activities for AQI 150'.";
    }
}
