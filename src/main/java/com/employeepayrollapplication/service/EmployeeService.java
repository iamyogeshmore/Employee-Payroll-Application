package com.employeepayrollapplication.service;

import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //--------------------------------- Get String Message ---------------------------------
    public String employeeMessage() {
        return "Hello World";
    }

    //--------------------------------- Add employee ---------------------------------
    @Override
    public Employee saveEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //--------------------------------- Get all employee ---------------------------------
    @Override
    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    //--------------------------------- Edit employee data ---------------------------------
    @Override
    public Employee editEmployee(Employee employee, Integer id) {
        Employee existingGreet = employeeRepository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setName(employee.getName());
            ;
            return employeeRepository.save(existingGreet);
        } else return null;
    }

    //--------------------------------- Delete employee ---------------------------------
    @Override
    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "Data Deleted";
    }
}


