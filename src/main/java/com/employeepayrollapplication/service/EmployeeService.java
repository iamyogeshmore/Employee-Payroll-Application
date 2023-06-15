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

    //--------------- UC 2 ---------------//

    @Override
    public Employee saveEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee editEmployee(Employee employee, Integer id) {
        Employee existingGreet = employeeRepository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setName(employee.getName());
            ;
            return employeeRepository.save(existingGreet);
        } else return null;
    }

    @Override
    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "Data Deleted";
    }
}


