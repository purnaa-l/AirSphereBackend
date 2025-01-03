package com.postgresql.aqi.service.impl;

import com.postgresql.aqi.entity.CitiesAdded;
import com.postgresql.aqi.repository.CitiesAddedRepository;
import com.postgresql.aqi.service.CitiesAddedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesAddedImpl implements CitiesAddedService {

    @Autowired
    private CitiesAddedRepository citiesAddedRepository;
    @Override
    public CitiesAdded saveCity(CitiesAdded citiesAdded) {
        return citiesAddedRepository.save(citiesAdded);
    }

    @Override
    public List<CitiesAdded> getAllCities() {
        return citiesAddedRepository.findAll();
    }

    @Override
    public CitiesAdded getCityById(Long id) {
        Optional<CitiesAdded> city=citiesAddedRepository.findById(id);
        if(city.isEmpty()){
            throw new RuntimeException("City for this ID not found!");
        }
        else{
            return city.get();
        }
    }

    @Override
    public void deleteCityById(Long id) {
         citiesAddedRepository.deleteById(id);

    }
}
