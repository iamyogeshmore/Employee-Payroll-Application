package com.employeepayrollapplication.service;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.model.Employee;

import java.util.List;

public interface iEmployeeService {
    List<Employee> ShowAllEmployee();

    Employee FindEmployeeDataById(int empId);

    Employee RegisterEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployeeData(int empId, EmployeeDTO employeeDTO);

    String deleteEmployeeByeId(int empId);

    List<Employee> getEmployeesByDepartment(String department);
}