package com.employeepayrollapplication.service;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {
    @Autowired
    EmployeeRepository repository;

    //--------------------------------- Add employee ---------------------------------
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee empData = new Employee(employeeDTO);
        return repository.save(empData);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return repository.findById(empId).orElse(null);
    }

    //--------------------------------- Get all employee ---------------------------------
    @Override
    public List<Employee> getEmployeeData() {
        return repository.findAll();
    }

    //--------------------------------- Edit employee data ---------------------------------
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployee(employeeDTO);
        return repository.save(empData);
    }

    //--------------------------------- Delete employee ---------------------------------
    public String deleteEmployeePayrollData(int empID) {
        repository.deleteById(empID);
        return "Data Deleted";
    }
}