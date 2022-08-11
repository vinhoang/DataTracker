package com.datatracker.data.repositories;

import com.datatracker.data.dtos.MetricDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<MetricDTO, String> {
}
