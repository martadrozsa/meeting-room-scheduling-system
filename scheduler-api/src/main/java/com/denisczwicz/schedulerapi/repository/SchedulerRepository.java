package com.denisczwicz.schedulerapi.repository;

import com.denisczwicz.schedulerapi.model.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {
}
