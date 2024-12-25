package com.postgresql.aqi.repository;

import com.postgresql.aqi.entity.HistoricalDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetHistoricalDataRepository extends JpaRepository<HistoricalDataEntity, Integer> {
}
