package com.postgresql.aqi.controller;

import com.postgresql.aqi.entity.ContactUs;
import com.postgresql.aqi.service.ContactUsService;
import com.postgresql.aqi.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;  // Correct import
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/aqi/contact-us")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @Autowired
    private EmailService emailService;  // Autowire EmailService

    // Save a new query
    @PostMapping
    public ResponseEntity<ContactUs> saveQuery(@RequestBody ContactUs contactUs) throws MessagingException {
        if (contactUs.getEmail() == null || contactUs.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body(null);  // Returning a bad request if email is missing
        }

        // Save the contact query
        ContactUs savedQuery = contactUsService.saveQuery(contactUs);

        // Send a confirmation email to the user
        emailService.sendPersonalizedEmail(
                contactUs.getEmail(),
                contactUs.getName(),
                contactUs.getQuery()
        );

        // Return the saved query as a response
        return ResponseEntity.ok(savedQuery);
    }

    // Get all queries
    @GetMapping
    public ResponseEntity<List<ContactUs>> getAllQueries() {
        List<ContactUs> queries = contactUsService.getAllQueries();
        return ResponseEntity.ok(queries);
    }

    // Get a query by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactUs> getQueryById(@PathVariable long id) {
        ContactUs query = contactUsService.getQueryById(id);
        return ResponseEntity.ok(query);
    }

    // Delete a query by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQueryById(@PathVariable long id) {
        contactUsService.deleteQueryById(id);
        return ResponseEntity.noContent().build();
    }
}
