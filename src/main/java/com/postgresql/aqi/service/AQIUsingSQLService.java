package com.postgresql.aqi.service;

import java.util.List;

public interface AQIUsingSQLService {
    List<Object[]> getAvgAqiByCity();
    List<Object[]> getRecordCountByCity();
    List<Object[]> getMaxAqiByCity();
    List<Object[]> getMinAqiByCity();
}
