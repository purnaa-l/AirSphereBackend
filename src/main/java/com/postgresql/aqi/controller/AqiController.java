package com.postgresql.aqi.controller;

import com.postgresql.aqi.dto.AqiDto;
import com.postgresql.aqi.service.AqiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/aqi")
public class AqiController {
    private final AqiService aqiService;

    public AqiController(AqiService aqiService) {
        this.aqiService = aqiService;
    }

    // Build add AQI REST API
    @PostMapping
    public ResponseEntity<AqiDto> createAqi(@RequestBody AqiDto aqiDto) {
        AqiDto savedAqi = aqiService.createAqi(aqiDto);
        return new ResponseEntity<>(savedAqi, HttpStatus.CREATED);
    }

    //Build get AQI rest API

    @GetMapping("{id}")
    public ResponseEntity<AqiDto> getAqiById(@PathVariable("id") Long aqiId){
        AqiDto aqiDto=aqiService.getAqi(aqiId);
        return ResponseEntity.ok(aqiDto);
    }

    //Build get all AQIs rest API

    @GetMapping
    public ResponseEntity<List<AqiDto>> getAllAqis(){
        List<AqiDto> aqi=aqiService.getAllAQIs();
        return ResponseEntity.ok(aqi);
    }

    //Build delete AQI rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteAQI(@PathVariable("id") Long aqiId){
        aqiService.deleteAQI(aqiId);
        return ResponseEntity.ok("AQI Successfully Deleted!");
    }
}
