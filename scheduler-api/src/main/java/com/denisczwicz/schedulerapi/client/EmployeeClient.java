package com.denisczwicz.schedulerapi.client;

import com.denisczwicz.schedulerapi.controller.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "${client.employee.name}", url = "${client.employee.url}", decode404 = true)
public interface EmployeeClient {

    @GetMapping("/employee/{id}")
    Optional<EmployeeDTO> getById(@PathVariable("id") Long id);
}
