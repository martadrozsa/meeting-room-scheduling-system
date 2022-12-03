package com.denisczwicz.schedulerapi.controller;

import com.denisczwicz.schedulerapi.controller.dto.SchedulerDTO;
import com.denisczwicz.schedulerapi.model.Scheduler;
import com.denisczwicz.schedulerapi.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @GetMapping("/")
    public List<SchedulerDTO> findAll() {
        List<Scheduler> data = schedulerService.getAll();
        return SchedulerDTO.convertSchedulerList(data);
    }
}
