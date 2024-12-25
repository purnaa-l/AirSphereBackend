package com.postgresql.aqi.controller;

import com.postgresql.aqi.entity.HistoricalDataEntity;
import com.postgresql.aqi.service.GetHistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

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
}