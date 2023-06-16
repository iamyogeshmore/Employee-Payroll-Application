package com.employeepayrollapplication.service;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.model.Employee;

import java.util.List;

public interface iEmployeeService {
    List<Employee> getEmployeeData();

    Employee getEmployeePayrollDataById(int empId);

    Employee createEmployeePayrollData(EmployeeDTO employeeDTO);

    Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO);

    String deleteEmployeePayrollData(int empId);

    List<Employee> getEmployeesByDepartment(String department);
}