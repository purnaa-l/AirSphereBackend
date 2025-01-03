package com.postgresql.aqi.repository;

import com.postgresql.aqi.entity.CitiesAdded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesAddedRepository extends JpaRepository<CitiesAdded, Long> {
}
