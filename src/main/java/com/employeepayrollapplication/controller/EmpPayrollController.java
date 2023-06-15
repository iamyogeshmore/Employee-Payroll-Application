package com.employeepayrollapplication.controller;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.dto.ResponseDTO;
import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpPayrollController {
    @Autowired
    public EmployeeService service;

    //--------------------------------- Get String Message ---------------------------------
    @RequestMapping("/welcome")
    public String displayMessage() {
        return service.employeeMessage();
    }
    //--------------------------------- Add employee ---------------------------------

    @PostMapping("/Register_Employee")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeeDTO empDTO) {
        Employee empData = null;
        empData = new Employee(1, empDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @GetMapping("/Find_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        Employee empData = null;
        empData = new Employee(1, new EmployeeDTO("Yogesh", "Male", "HR", 45000));
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Get all employee ---------------------------------
    @GetMapping("/Show_All_Emp_Data")
    public List<Employee> findAllEmployees() {
        return service.findEmployees();
    }

    //--------------------------------- Edit employee data ---------------------------------
    @PutMapping("/Update_Employee_Data")
    public ResponseEntity<ResponseDTO> editEmployeePayrollData(@RequestBody EmployeeDTO empDTO) {
        Employee empData = null;
        empData = new Employee(1, empDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete employee ---------------------------------
    @DeleteMapping("/Delete_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respOTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }
}

