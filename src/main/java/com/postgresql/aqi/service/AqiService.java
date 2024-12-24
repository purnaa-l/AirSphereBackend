package com.postgresql.aqi.service;

import com.postgresql.aqi.dto.AqiDto;

public interface AqiService {
    AqiDto createAqi(AqiDto aqiDto);
    AqiDto getAqi(Long aqiId);
}
