package com.denisczwicz.schedulerapi.service;

import com.denisczwicz.schedulerapi.client.EmployeeClient;
import com.denisczwicz.schedulerapi.client.RoomClient;
import com.denisczwicz.schedulerapi.model.Scheduler;
import com.denisczwicz.schedulerapi.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    private final EmployeeClient employeeClient;

    private final RoomClient roomClient;

    public List<Scheduler> getAll() {
        // TODO: antes de devolver os dados, bater no ms funcionario e sala pra pegar os nomes e preencher no obj Agenda.
        // TODO: fazer uma funcao que recebe a agenda e preenche esses dados. Fazer um for na lista de agendas pra chamar essa funcao.
        return schedulerRepository.findAll();
    }



}
