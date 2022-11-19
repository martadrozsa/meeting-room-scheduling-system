package com.denisczwicz.employeeapi.controller.dto;

import com.denisczwicz.employeeapi.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private String admissionDate;
    private String birthDate;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.admissionDate = employee.getAdmissionDate().format(DATE_TIME_FORMATTER);
        this.birthDate = employee.getBirthDate().format(DATE_TIME_FORMATTER);
    }

    public Employee convertEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setAdmissionDate(LocalDate.parse(this.getAdmissionDate(), DATE_TIME_FORMATTER));
        employee.setBirthDate(LocalDate.parse(this.getBirthDate(), DATE_TIME_FORMATTER));
        return employee;
    }

    public static EmployeeDTO convertEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setAdmissionDate(DATE_TIME_FORMATTER.format(employee.getAdmissionDate()));
        employeeDTO.setBirthDate(DATE_TIME_FORMATTER.format(employee.getBirthDate()));
        return employeeDTO;
    }

    public static List<EmployeeDTO> convertDTOList(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO(employee);
            employeeDTOS.add(employeeDTO);
        }

        return employeeDTOS;
    }
}
