package com.postgresql.aqi.repository;

import com.postgresql.aqi.entity.Aqi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AQIUsingSQLRepository extends JpaRepository<Aqi, Long> {

    // Aggregate query to get average AQI by city
    @Query("SELECT a.city, AVG(a.AQI) FROM Aqi a GROUP BY a.city")
    List<Object[]> findAvgAqiByCity();

    // Aggregate query to get record count by city
    @Query("SELECT a.city, COUNT(a) FROM Aqi a GROUP BY a.city")
    List<Object[]> findRecordCountByCity();

    // Aggregate query to get the maximum AQI by city
    @Query("SELECT a.city, MAX(a.AQI) FROM Aqi a GROUP BY a.city")
    List<Object[]> findMaxAqiByCity();

    // Aggregate query to get minimum AQI by city
    @Query("SELECT a.city, MIN(a.AQI) FROM Aqi a GROUP BY a.city")
    List<Object[]> findMinAqiByCity();
}
