package com.postgresql.aqi.model;

public class EmergencyContacts {

    public static String getEmergencyContacts() {
        return """
                Toll-Free Numbers for Emergency Services:
                1. National Emergency Services: 112
                2. Poison Control: 1-800-222-1222
                3. Air Pollution Emergency: 1-800-222-1222
                
                Nearest Emergency Contacts:
                Please visit your local hospitals and clinics for the nearest emergency contact.
                
                For more localized information, you can call your local hospital or find nearby medical centers.""";
    }
}
