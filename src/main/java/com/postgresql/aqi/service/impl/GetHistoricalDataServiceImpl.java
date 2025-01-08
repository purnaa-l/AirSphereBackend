package com.postgresql.aqi.service.impl;

import com.postgresql.aqi.entity.HistoricalDataEntity;
import com.postgresql.aqi.repository.GetHistoricalDataRepository;
import com.postgresql.aqi.service.GetHistoricalDataService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetHistoricalDataServiceImpl implements GetHistoricalDataService {

    private final GetHistoricalDataRepository historicalDataRepository;

    @Autowired
    public GetHistoricalDataServiceImpl(GetHistoricalDataRepository historicalDataRepository) {
        this.historicalDataRepository = historicalDataRepository;
    }

    @Override
    public List<HistoricalDataEntity> getAllHistoricalData() {
        return historicalDataRepository.findAll(); // Fetch all data
    }

    @Override
    public Optional<HistoricalDataEntity> getHistoricalDataById(Integer id) {
        return historicalDataRepository.findById(id); // Fetch data by ID
    }

    @Override
    public List<HistoricalDataEntity> getHistoricalDataByCity(String city) {
        return historicalDataRepository.findByCityOrderByDateDesc(city); // Fetch data by city
    }

    @Override
    @Transactional
    public HistoricalDataEntity saveData(HistoricalDataEntity historicalDataEntity) {
        System.out.println("Saving data: " + historicalDataEntity);
        return historicalDataRepository.save(historicalDataEntity);
    }

}
