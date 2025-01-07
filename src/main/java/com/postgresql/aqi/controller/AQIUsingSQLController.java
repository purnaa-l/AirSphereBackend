package com.postgresql.aqi.controller;

import com.postgresql.aqi.service.AQIUsingSQLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/sql/aqi")
public class AQIUsingSQLController {

    private final AQIUsingSQLService aqiUsingSQLService;

    public AQIUsingSQLController(AQIUsingSQLService aqiUsingSQLService) {
        this.aqiUsingSQLService = aqiUsingSQLService;
    }

    // Get average AQI by city
    @GetMapping("/avg-aqi")
    public ResponseEntity<List<Object[]>> getAvgAqiByCity() {
        List<Object[]> data = aqiUsingSQLService.getAvgAqiByCity();
        return ResponseEntity.ok(data);
    }

    // Get record count by city
    @GetMapping("/record-count")
    public ResponseEntity<List<Object[]>> getRecordCountByCity() {
        List<Object[]> data = aqiUsingSQLService.getRecordCountByCity();
        return ResponseEntity.ok(data);
    }

    // Get max AQI by city
    @GetMapping("/max-aqi")
    public ResponseEntity<List<Object[]>> getMaxAqiByCity() {
        List<Object[]> data = aqiUsingSQLService.getMaxAqiByCity();
        return ResponseEntity.ok(data);
    }

    // Get min AQI by city
    @GetMapping("/min-aqi")
    public ResponseEntity<List<Object[]>> getMinAqiByCity() {
        List<Object[]> data = aqiUsingSQLService.getMinAqiByCity();
        return ResponseEntity.ok(data);
    }
}
