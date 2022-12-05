package com.denisczwicz.schedulerapi.controller;

import com.denisczwicz.schedulerapi.controller.dto.SchedulerDTO;
import com.denisczwicz.schedulerapi.model.Scheduler;
import com.denisczwicz.schedulerapi.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<SchedulerDTO> getById(@PathVariable(name = "id")Long id) {
        Optional<SchedulerDTO> optionalScheduler = schedulerService.getById(id);
        if (optionalScheduler.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalScheduler.get());
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
