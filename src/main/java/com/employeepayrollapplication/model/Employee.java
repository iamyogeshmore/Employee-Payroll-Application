package com.employeepayrollapplication.model;

import com.employeepayrollapplication.dto.EmployeeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Employee {
    String name;
    String department;
    String gender;
    String salary;
    @Id
    @GeneratedValue

    int id;
    public Employee(int empId, EmployeeDTO employeeDTO) {
        this.id = empId;
        this.name = employeeDTO.name;
        this.department = employeeDTO.department;
        this.gender = employeeDTO.gender;
        this.salary = String.valueOf(employeeDTO.salary);
    }

}