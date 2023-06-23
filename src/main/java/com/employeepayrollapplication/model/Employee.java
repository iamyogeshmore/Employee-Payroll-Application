package com.employeepayrollapplication.model;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "employee")

public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    private String name;
    private Long salary;
    private String gender;
    private String profilePic;
    private String note;
    @JsonFormat(pattern = "dd-MM-yyyy") // "23-06-2023"
    private Date startDate;
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @ElementCollection
    public List<String> department;

    public Employee(EmployeeDTO employeeDTO) {
        this.updateEmployee(employeeDTO);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.department = employeeDTO.department;
        this.gender = employeeDTO.gender;
        this.salary = employeeDTO.salary;
        this.startDate = employeeDTO.getStartDate();
        this.profilePic = employeeDTO.profilePic;
        this.note = employeeDTO.note;
    }
}