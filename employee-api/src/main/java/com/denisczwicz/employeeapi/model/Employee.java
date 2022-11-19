package com.denisczwicz.employeeapi.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;





}
