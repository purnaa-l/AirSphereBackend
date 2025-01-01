package com.postgresql.aqi.model;

import java.util.HashMap;
import java.util.Map;

public class AQIInfo {

    private static final Map<Integer, String> aqiRanges = new HashMap<>();
    private static final Map<Integer, String> aqiActivities = new HashMap<>();

    static {
        // AQI ranges and their meanings
        aqiRanges.put(0, "Good (0-50): Air quality is considered satisfactory, and air pollution poses little or no risk.");
        aqiRanges.put(51, "Moderate (51-100): Air quality is acceptable; however, there may be some health concern for sensitive people.");
        aqiRanges.put(101, "Unhealthy for Sensitive Groups (101-150): Members of sensitive groups (e.g., children, elderly, and people with respiratory conditions) may experience health effects.");
        aqiRanges.put(151, "Unhealthy (151-200): Everyone may begin to experience health effects, and members of sensitive groups may experience more serious effects.");
        aqiRanges.put(201, "Very Unhealthy (201-300): Health alert: everyone may experience more serious health effects.");
        aqiRanges.put(301, "Hazardous (301-500): Health warning of emergency conditions. The entire population is more likely to be affected.");

        // Recommended activities for different AQI ranges
        aqiActivities.put(0, "Outdoor activities such as jogging, cycling, or any exercise are safe.");
        aqiActivities.put(51, "Sensitive individuals should limit prolonged outdoor exertion.");
        aqiActivities.put(101, "Sensitive individuals should avoid outdoor activities, and others should limit prolonged exertion.");
        aqiActivities.put(151, "Everyone should avoid outdoor activities; sensitive individuals should remain indoors.");
        aqiActivities.put(201, "Everyone should avoid outdoor activities. Stay indoors and avoid exertion.");
        aqiActivities.put(301, "Health warnings of emergency conditions. The entire population is at risk. Stay indoors and avoid any outdoor activity.");
    }

    public static String aqiInfo() {
        return """
                AQI stands for "Air Quality Index."
                It's a way to tell how clean or dirty the air is.
                If the AQI number is low, the air is clean, and it's safe to breathe.
                If the AQI number is high, the air is dirty, and it might not be safe to breathe, especially for people who have trouble with their lungs, like those with asthma.
                Think of it like a traffic light: green means good air, yellow means be careful, and red means the air is not so good.
               """;
    }

    public static String getAQIInfo(int aqiValue) {
        // Find the appropriate range
        for (Map.Entry<Integer, String> entry : aqiRanges.entrySet()) {
            if (aqiValue >= entry.getKey()) {
                return entry.getValue();
            }
        }
        return "Invalid AQI value.";
    }

    public static String getRecommendedActivities(int aqiValue) {
        // Adjusted logic to find the appropriate activity recommendation based on AQI ranges
        StringBuilder response = new StringBuilder();

        if (aqiValue >= 0 && aqiValue <= 50) {
            response.append("• Outdoor activities such as jogging, cycling, or any exercise are safe.\n");
        } else if (aqiValue >= 51 && aqiValue <= 100) {
            response.append("• Sensitive individuals should limit prolonged outdoor exertion.\n");
            response.append("• Others may continue outdoor activities but should monitor their health.\n");
        } else if (aqiValue >= 101 && aqiValue <= 150) {
            response.append("• Sensitive individuals should avoid outdoor activities.\n");
            response.append("• Others should limit prolonged outdoor exertion.\n");
        } else if (aqiValue >= 151 && aqiValue <= 200) {
            response.append("• Everyone should avoid outdoor activities.\n");
            response.append("• Sensitive individuals should remain indoors.\n");
        } else if (aqiValue >= 201 && aqiValue <= 300) {
            response.append("• Everyone should avoid outdoor activities.\n");
            response.append("• Stay indoors and avoid physical exertion.\n");
        } else if (aqiValue >= 301 && aqiValue <= 500) {
            response.append("• Health warnings of emergency conditions. The entire population is at risk.\n");
            response.append("• Stay indoors and avoid any outdoor activity.\n");
        }

        // Return the activities with proper formatting
        return !response.isEmpty() ? response.toString() : "No activity recommendations available.";
    }
}
