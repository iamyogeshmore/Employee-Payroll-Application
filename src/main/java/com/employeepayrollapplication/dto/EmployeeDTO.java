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

    public String getEmployee_name() {
        return name;
    }

    public void setEmployee_name(String employee_name) {
        this.name = employee_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}