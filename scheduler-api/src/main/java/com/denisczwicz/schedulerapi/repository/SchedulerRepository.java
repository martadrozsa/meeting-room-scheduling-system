package com.denisczwicz.schedulerapi.repository;

import com.denisczwicz.schedulerapi.model.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {

    boolean existsSchedulerByRoomAndReservationPeriod(Long room, LocalDateTime reservationPeriod);

}

