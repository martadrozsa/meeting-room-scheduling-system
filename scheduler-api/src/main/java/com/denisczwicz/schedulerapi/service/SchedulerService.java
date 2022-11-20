package com.denisczwicz.schedulerapi.service;

import com.denisczwicz.schedulerapi.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SchedulerService {

    private SchedulerRepository schedulerRepository;
}
