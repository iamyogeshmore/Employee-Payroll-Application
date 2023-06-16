package com.employeepayrollapplication.model;

import com.employeepayrollapplication.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "employee")

public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue
    int id;
    @Column(name = "name")
    private String name;
    private Long salary;
    private String gender;
    private String profilePic;
    private String note;
    private LocalDate startDate;
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @ElementCollection
    public List<String> department;

    public Employee(EmployeeDTO employeeDTO) {
        this.updateEmployee(employeeDTO);
    }
    public void updateEmployee(EmployeeDTO employeeDTO){
        this.name= employeeDTO.name;
        this.department=employeeDTO.department;
        this.gender=employeeDTO.gender;
        this.salary=employeeDTO.salary;
        this.startDate=employeeDTO.startDate;
        this.profilePic=employeeDTO.profilePic;
        this.note=employeeDTO.note;
    }
}