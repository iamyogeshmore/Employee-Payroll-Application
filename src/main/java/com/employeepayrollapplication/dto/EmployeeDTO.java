package com.employeepayrollapplication.dto;

public class EmployeeDTO {
    public String name;
    public String gender;
    public String department;
    public long salary;

    public EmployeeDTO(String name, String gender, String department, long salary) {
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }
}