package com.postgresql.aqi.controller;

import com.postgresql.aqi.entity.HistoricalDataEntity;
import com.postgresql.aqi.service.GetHistoricalDataService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // specify your frontend URL here
@RestController
@RequestMapping("/api/historical-data") // Base URL for the endpoint
public class GetHistoricalDataController {

    private final GetHistoricalDataService getHistoricalDataService;

    @Autowired
    public GetHistoricalDataController(GetHistoricalDataService getHistoricalDataService) {
        this.getHistoricalDataService = getHistoricalDataService;
    }

    // Get all historical data
    @GetMapping
    public List<HistoricalDataEntity> getAllHistoricalData() {
        return getHistoricalDataService.getAllHistoricalData();
    }

    // Get historical data by ID
    @GetMapping("/{id}")
    public Optional<HistoricalDataEntity> getHistoricalDataById(@PathVariable Integer id) {
        return getHistoricalDataService.getHistoricalDataById(id);
    }
    @PostMapping
    public ResponseEntity<HistoricalDataEntity> insertOrUpdateData(@RequestBody HistoricalDataEntity historicalDataEntity) {
        // Handle insert or update based on slNo existence
        if (historicalDataEntity.getSlNo() != null && getHistoricalDataService.getHistoricalDataById(historicalDataEntity.getSlNo()).isPresent()) {
            HistoricalDataEntity updatedEntity = getHistoricalDataService.saveData(historicalDataEntity);
            return ResponseEntity.ok(updatedEntity); // Return 200 OK with updated data
        } else {
            // Remove slNo from the entity if it's null for new data
            historicalDataEntity.setSlNo(null); // To avoid setting a null value for slNo
            HistoricalDataEntity newEntity = getHistoricalDataService.saveData(historicalDataEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEntity); // Return 201 Created with new data
        }
    }





    // Get historical data by city
    @GetMapping("/city")
    public List<HistoricalDataEntity> getHistoricalDataByCity(@RequestParam String city) {
        return getHistoricalDataService.getHistoricalDataByCity(city);
    }
}
