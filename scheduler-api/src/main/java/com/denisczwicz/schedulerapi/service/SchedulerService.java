package com.denisczwicz.schedulerapi.service;

import com.denisczwicz.schedulerapi.client.EmployeeClient;
import com.denisczwicz.schedulerapi.client.RoomClient;
import com.denisczwicz.schedulerapi.controller.dto.EmployeeDTO;
import com.denisczwicz.schedulerapi.controller.dto.RoomDTO;
import com.denisczwicz.schedulerapi.controller.dto.SchedulerDTO;
import com.denisczwicz.schedulerapi.model.Scheduler;
import com.denisczwicz.schedulerapi.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    private final EmployeeClient employeeClient;

    private final RoomClient roomClient;

    public List<Scheduler> getAll() {
       return schedulerRepository.findAll();
    }

    public Optional<SchedulerDTO> getById(Long id) {
        Optional<Scheduler> optScheduler = schedulerRepository.findById(id);

        if (optScheduler.isEmpty()) {
            return Optional.empty();
        }

        Scheduler scheduler = optScheduler.get();

        Optional<EmployeeDTO> optionalEmployeeDTO = employeeClient.getById(scheduler.getResponsible());
        if (optionalEmployeeDTO.isEmpty()) {
            return Optional.empty();
        }

        Optional<RoomDTO> optionalRoomDTO = roomClient.getById(scheduler.getRoom());
        if (optionalRoomDTO.isEmpty()) {
            return Optional.empty();
        }

        EmployeeDTO employeeDTO = optionalEmployeeDTO.get();
        RoomDTO roomDTO = optionalRoomDTO.get();
        SchedulerDTO schedulerDTO = new SchedulerDTO(scheduler);

        schedulerDTO.setResponsible(employeeDTO.getName());
        schedulerDTO.setRoom(roomDTO.getName());

        return Optional.of(schedulerDTO);
    }

    public SchedulerDTO save(Scheduler scheduler) {

        Optional<EmployeeDTO> optionalEmployeeDTO = employeeClient.getById(scheduler.getResponsible());
        if (optionalEmployeeDTO.isEmpty()) {
            return null;
        }

        Optional<RoomDTO> optionalRoomDTO = roomClient.getById(scheduler.getRoom());
        if (optionalRoomDTO.isEmpty()) {
            return null;
        }

        int minutes = scheduler.getReservationPeriod().getMinute();
        LocalDateTime targetDateTime = scheduler.getReservationPeriod().minusMinutes(minutes);

        if (schedulerRepository.existsSchedulerByRoomAndReservationPeriod(scheduler.getRoom(), targetDateTime)) {
            return null;
        }

        scheduler.setReservationPeriod(targetDateTime);

        EmployeeDTO employeeDTO = optionalEmployeeDTO.get();
        RoomDTO roomDTO = optionalRoomDTO.get();

        Scheduler saved = schedulerRepository.save(scheduler);

        SchedulerDTO schedulerDTO = new SchedulerDTO(saved);

        schedulerDTO.setResponsible(employeeDTO.getName());
        schedulerDTO.setRoom(roomDTO.getName());

        return schedulerDTO;
    }
}
