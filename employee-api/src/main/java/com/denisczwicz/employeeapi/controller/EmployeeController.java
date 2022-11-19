package com.denisczwicz.employeeapi.controller;

import com.denisczwicz.employeeapi.controller.dto.EmployeeDTO;
import com.denisczwicz.employeeapi.model.Employee;
import com.denisczwicz.employeeapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAll()  {
        List<Employee> employees = employeeService.getAll();
        List<EmployeeDTO> employeeDTOList = EmployeeDTO.convertDTOList(employees);
        return ResponseEntity.ok().body(employeeDTOList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDTO> getById(@PathVariable(name = "id")Long id) {
        Optional<Employee> optionalEmployee = employeeService.getById(id);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new EmployeeDTO(optionalEmployee.get()));
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.convertEmployee();
        employeeService.insert(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
