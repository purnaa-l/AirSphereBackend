package com.postgresql.aqi.repository;

import com.postgresql.aqi.entity.HistoricalDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetHistoricalDataRepository extends JpaRepository<HistoricalDataEntity, Integer> {

    // Query to find historical data by city and order by date in descending order
    List<HistoricalDataEntity> findByCityOrderByDateDesc(String city);
}
