package com.denisczwicz.schedulerapi.controller.dto;

import com.denisczwicz.schedulerapi.model.Scheduler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class SchedulerDTO {

    private Long id;

    private Long idResponsible;
    private String responsible;

    private Long idRoom;
    private String room;
    private String reservationDateAndTime;

    private static final DateTimeFormatter FORMAT_DATE_TIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public SchedulerDTO(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.idResponsible = scheduler.getResponsible();
        this.idRoom = scheduler.getRoom();
        this.reservationDateAndTime = scheduler.getReservationPeriod().format(FORMAT_DATE_TIME);
    }

    public Scheduler convertScheduler() {
        Scheduler scheduler = new Scheduler();

        if (this.getId() != null) {
            scheduler.setId(this.getId());
        }
        scheduler.setResponsible(this.getIdResponsible());
        scheduler.setRoom(this.getIdRoom());
        scheduler.setReservationPeriod(LocalDateTime.parse(this.getReservationDateAndTime(), FORMAT_DATE_TIME));
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
