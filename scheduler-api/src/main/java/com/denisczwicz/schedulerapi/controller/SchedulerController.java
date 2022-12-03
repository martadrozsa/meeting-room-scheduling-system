package com.denisczwicz.schedulerapi.controller;

import com.denisczwicz.schedulerapi.controller.dto.SchedulerDTO;
import com.denisczwicz.schedulerapi.model.Scheduler;
import com.denisczwicz.schedulerapi.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @GetMapping("/")
    public List<SchedulerDTO> findAll() {
        List<Scheduler> schedulers = schedulerService.getAll();
        return SchedulerDTO.convertSchedulerList(schedulers);
    }

    @PostMapping("/")
    public ResponseEntity<SchedulerDTO> save(@RequestBody SchedulerDTO schedulerDTO) {
        if (schedulerDTO.getIdResponsible() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        if (schedulerDTO.getIdRoom() == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        if (schedulerDTO.getReservationDateAndTime() == null || schedulerDTO.getReservationDateAndTime().isBlank()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        SchedulerDTO dto = schedulerService.save(schedulerDTO.convertScheduler());

        if (dto == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok(dto);
    }
}
