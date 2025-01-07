package com.postgresql.aqi.service.impl;

import com.postgresql.aqi.service.AQIUsingSQLService;
import com.postgresql.aqi.repository.AQIUsingSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AQIUsingSQLServiceImpl implements AQIUsingSQLService {

    private final AQIUsingSQLRepository aqiUsingSQLRepository;

    @Autowired
    public AQIUsingSQLServiceImpl(AQIUsingSQLRepository aqiUsingSQLRepository) {
        this.aqiUsingSQLRepository = aqiUsingSQLRepository;
    }

    @Override
    public List<Object[]> getAvgAqiByCity() {
        return aqiUsingSQLRepository.findAvgAqiByCity();
    }

    @Override
    public List<Object[]> getRecordCountByCity() {
        return aqiUsingSQLRepository.findRecordCountByCity();
    }

    @Override
    public List<Object[]> getMaxAqiByCity() {
        return aqiUsingSQLRepository.findMaxAqiByCity();
    }

    @Override
    public List<Object[]> getMinAqiByCity() {
        return aqiUsingSQLRepository.findMinAqiByCity();
    }
}
