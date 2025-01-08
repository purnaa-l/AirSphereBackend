package com.postgresql.aqi.controller;

import com.postgresql.aqi.entity.CitiesAdded;
import com.postgresql.aqi.service.CitiesAddedService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/aqi/admin/add-cities")
public class CitiesAddedController {
    @Autowired
    private CitiesAddedService citiesAddedService;

    @PostMapping
    public ResponseEntity<CitiesAdded> saveCity(@RequestBody CitiesAdded citiesAdded) throws MessagingException{
        if(citiesAdded.getDescription()==null || citiesAdded.getDescription().isEmpty() || citiesAdded.getCity().isEmpty()||citiesAdded.getCity().isBlank()){
            return ResponseEntity.badRequest().body(null);
        }
        CitiesAdded savedCity=citiesAddedService.saveCity(citiesAdded);
        return ResponseEntity.ok(savedCity);
    }

    @CrossOrigin(origins = "http://localhost:5173") // Allow requests from frontend
    @GetMapping
    public ResponseEntity<List<CitiesAdded>> getAllCities(){
        List<CitiesAdded> citiesAddedList=citiesAddedService.getAllCities();
        return ResponseEntity.ok(citiesAddedList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitiesAdded> getCityById(@PathVariable long id){
        CitiesAdded citiesAdded=citiesAddedService.getCityById(id);
        return ResponseEntity.ok(citiesAdded);
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable long id){
        citiesAddedService.deleteCityById(id);
        ResponseEntity.noContent().build();
    }

}
