package com.example.assignment9_eregistrar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;
    private boolean isInternational;
}