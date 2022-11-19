package com.denisczwicz.employeeapi.controller;

import com.denisczwicz.employeeapi.controller.dto.EmployeeDTO;
import com.denisczwicz.employeeapi.model.Employee;
import com.denisczwicz.employeeapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDTO> getById(@PathVariable(name = "id")Long id) {
        Optional<Employee> optionalEmployee = employeeService.getById(id);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new EmployeeDTO(optionalEmployee.get()));
    }
}
