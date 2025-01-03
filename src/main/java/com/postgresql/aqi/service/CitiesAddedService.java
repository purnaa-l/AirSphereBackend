package com.postgresql.aqi.service;

import com.postgresql.aqi.entity.CitiesAdded;

import java.util.List;

public interface CitiesAddedService {
    CitiesAdded saveCity(CitiesAdded citiesAdded);
    List<CitiesAdded> getAllCities();
    CitiesAdded getCityById(Long id);
    void deleteCityById(Long id);

}
