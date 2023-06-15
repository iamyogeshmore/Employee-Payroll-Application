package com.employeepayrollapplication.service;

import com.employeepayrollapplication.model.Employee;

import java.util.List;

public interface iEmployeeService {
    Employee saveEmployees(Employee employee);
    Employee findEmployeeById(Integer id);
    List<Employee> findEmployees();

    Employee editEmployee(Employee employee, Integer id);

    String deleteEmployee(Integer id);
}
