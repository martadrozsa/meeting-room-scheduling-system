package com.denisczwicz.schedulerapi.controller.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private String admissionDate;
    private String birthDate;
}