package com.employeepayrollapplication.service;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.exception.EmployeePayrollException;
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
    public Employee RegisterEmployee(EmployeeDTO employeeDTO) {
        String newName = employeeDTO.getName();
        Employee existingEmployee = repository.findByName(newName);
        if (existingEmployee != null) {
            throw new EmployeePayrollException("User already exists with the same name.");
        }
        Employee empData = new Employee(employeeDTO);
        return repository.save(empData);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @Override
    public Employee FindEmployeeDataById(int empId) {
        if (repository.findById(empId).isPresent()) {
            return repository.findById(empId).get();
        }
        throw new EmployeePayrollException("Employee Not Found + " + empId + " Invalid Id");
    }

    //--------------------------------- Get all employee ---------------------------------
    @Override
    public List<Employee> ShowAllEmployee() {
        return repository.findAll();
    }

    //--------------------------------- Edit employee data ---------------------------------
    @Override
    public Employee updateEmployeeData(int empId, EmployeeDTO employeeDTO) {
        Employee empData = this.FindEmployeeDataById(empId);
        if (empData == null) {
            throw new EmployeePayrollException("Employee not found with Id: " + empId);
        }
        if (repository.findByName(employeeDTO.getName()) == null) {

            if (employeeDTO.getName() != null) {
                empData.setName(employeeDTO.getName());
            }
            if (employeeDTO.getDepartment() != null) {
                empData.setDepartment(employeeDTO.getDepartment());
            }
            if (employeeDTO.getGender() != null) {
                empData.setGender(employeeDTO.getGender());
            }
            if (employeeDTO.getSalary() >= 500) {
                empData.setSalary(employeeDTO.getSalary());
            }
            if (employeeDTO.getStartDate() != null) {
                empData.setStartDate(employeeDTO.getStartDate());
            }
            if (employeeDTO.getProfilePic() != null) {
                empData.setProfilePic(employeeDTO.getProfilePic());
            }
            if (employeeDTO.getNote() != null) {
                empData.setNote(employeeDTO.getNote());
            }
            return repository.save(empData);
        }
        throw new EmployeePayrollException(employeeDTO.getName() + " This name is already exist." + " please try with another name");
    }

    //--------------------------------- Delete employee ---------------------------------
    public String deleteEmployeeByeId(int empID) {
        if (repository.findById(empID).isPresent()) {
            repository.deleteById(empID);
            return "Employee Data Deleted successful";
        }
        throw new EmployeePayrollException(" Employee not found with ID " + empID + " Invalid Id ");
    }

    //--------------------------------- Get employee by department ---------------------------------
    @Override
    public List<Employee> getEmployeesByDepartment(String department) {

        List<Employee> employeeList = repository.findEmployeeByDepartment(department);
        if (employeeList.isEmpty()) {
            throw new EmployeePayrollException("The " + department + " department does not have any employees");
        }
        return employeeList;
    }
}