package com.employeepayrollapplication.service;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.exception.EmployeePayrollException;
import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {
    @Autowired
    EmployeeRepository repository;
    private List<Employee> employeeList = new ArrayList<>();

    //--------------------------------- Add employee ---------------------------------
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee empData = new Employee(employeeList.size() + 1, employeeDTO);
        employeeList.add(empData);
        return repository.save(empData);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return employeeList.stream()
                .filter(empData -> empData.getId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    //--------------------------------- Get all employee ---------------------------------
    @Override
    public List<Employee> getEmployeeData() {
        return employeeList;
    }

    //--------------------------------- Edit employee data ---------------------------------
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeeDTO.name);
        empData.setDepartment(employeeDTO.department);
        empData.setGender(employeeDTO.gender);
        empData.setSalary(String.valueOf(employeeDTO.salary));
        employeeList.set(empId - 1, empData);
        return empData;
    }

    //--------------------------------- Delete employee ---------------------------------
    public void deleteEmployeePayrollData(int empID) {
        employeeList.remove(empID - 1);
    }
}