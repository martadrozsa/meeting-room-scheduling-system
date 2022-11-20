package com.denisczwicz.schedulerapi.controller.dto;

import com.denisczwicz.schedulerapi.model.Scheduler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class SchedulerDTO {

    private Long id;
    private Long responsible;
    private Long room;
    private LocalDateTime reservationDateAndTime;

    public SchedulerDTO(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.responsible = scheduler.getResponsible();
        this.room = scheduler.getRoom();
        this.reservationDateAndTime = scheduler.getReservationDateAndTime();
    }

    public Scheduler convertScheduler() {
        Scheduler scheduler = new Scheduler();

        if (this.getId() != null) {
            scheduler.setId(this.getId());
        }
        scheduler.setResponsible(this.getResponsible());
        scheduler.setRoom(this.getRoom());
        scheduler.setReservationDateAndTime(this.getReservationDateAndTime());
        return scheduler;
    }

    public static List<SchedulerDTO> convertSchedulerList(List<Scheduler> schedulerList) {
        List<SchedulerDTO> schedulerDTOS = new ArrayList<>();

        for (Scheduler scheduler : schedulerList) {
            SchedulerDTO schedulerDTO = new SchedulerDTO(scheduler);
            schedulerDTOS.add(schedulerDTO);
        }
        return schedulerDTOS;
    }
}
