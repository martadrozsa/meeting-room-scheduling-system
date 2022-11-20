package com.denisczwicz.schedulerapi.controller;

import com.denisczwicz.schedulerapi.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    private SchedulerService schedulerService;
}
