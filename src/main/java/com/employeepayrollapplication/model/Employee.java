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
    int id;
    String name;
    String department;
    String gender;
    long salary;
    String startDate;
    String note;
    String profilePic;


    public Employee(int empId, EmployeeDTO employeeDTO) {
        this.id = empId;
        this.name = employeeDTO.name;
        this.department = employeeDTO.department;
        this.gender = employeeDTO.gender;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.startDate;
        this.note = employeeDTO.note;
        this.profilePic = employeeDTO.profilePic;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}