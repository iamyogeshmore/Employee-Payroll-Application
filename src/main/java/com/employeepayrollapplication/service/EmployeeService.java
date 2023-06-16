package com.employeepayrollapplication.service;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {

    //--------------------------------- Add employee ---------------------------------
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee empData = null;
        empData = new Employee(1, employeeDTO);
        return empData;
    }

    //--------------------------------- Get employee by id ---------------------------------
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        Employee empData = null;
        empData = new Employee(1, new EmployeeDTO("Yogesh", "male", "Engg", 35000));
        return empData;
    }

    //--------------------------------- Get all employee ---------------------------------
    @Override
    public List<Employee> getEmployeeData() {
        List<Employee> empDataList = new ArrayList<>();
        empDataList.add(new Employee(1, new EmployeeDTO("Yogesh", "male", "Engg.", 35000)));
        return empDataList;
    }

    //--------------------------------- Edit employee data ---------------------------------
    @Override
    public Employee updateEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee empData = null;
        empData = new Employee(1, employeeDTO);
        return empData;
    }

    //--------------------------------- Delete employee ---------------------------------
    public void deleteEmployeePayrollData(int empID) {
    }
}