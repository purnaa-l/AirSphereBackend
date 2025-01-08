package com.postgresql.aqi.service;

import com.postgresql.aqi.entity.HistoricalDataEntity;
import java.util.List;
import java.util.Optional;

public interface GetHistoricalDataService {

    List<HistoricalDataEntity> getAllHistoricalData(); // Method to fetch all data
    Optional<HistoricalDataEntity> getHistoricalDataById(Integer id); // Method to fetch data by ID
    List<HistoricalDataEntity> getHistoricalDataByCity(String city); // Fetch data by city
    HistoricalDataEntity saveData(HistoricalDataEntity historicalDataEntity);
}
