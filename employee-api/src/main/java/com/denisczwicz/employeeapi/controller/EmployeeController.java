package com.denisczwicz.employeeapi.controller;

import com.denisczwicz.employeeapi.controller.dto.EmployeeDTO;
import com.denisczwicz.employeeapi.model.Employee;
import com.denisczwicz.employeeapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public List<EmployeeDTO> getAll()  {
        List<Employee> employees = employeeService.getAll();
        List<EmployeeDTO> employeeDTOList = EmployeeDTO.convertDTOList(employees);
        return employeeDTOList;
    }

}
