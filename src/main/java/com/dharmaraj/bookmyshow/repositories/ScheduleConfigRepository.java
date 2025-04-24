package com.dharmaraj.bookmyshow.repositories;

import com.dharmaraj.bookmyshow.models.ScheduleConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleConfigRepository extends JpaRepository<ScheduleConfig, Integer> {

    public Optional<ScheduleConfig> findByTaskName(String taskName);
}
