package com.denisczwicz.employeeapi.service;

import com.denisczwicz.employeeapi.model.Employee;
import com.denisczwicz.employeeapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        Employee saveEmployee = employeeRepository.getReferenceById(id);
        saveEmployee.setId(employee.getId());
        return employeeRepository.save(saveEmployee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
