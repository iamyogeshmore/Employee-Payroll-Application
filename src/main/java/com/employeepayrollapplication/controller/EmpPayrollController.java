package com.employeepayrollapplication.controller;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.dto.ResponseDTO;
import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpPayrollController {
    @Autowired
    public EmployeeService service;
    List<Employee> empDatalist = new ArrayList<>();

    //--------------------------------- Add employee ---------------------------------
    @PostMapping("/Register_Employee")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
            @RequestBody EmployeeDTO empPayrollDTO) {
        Employee empData = null;
        empData = service.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respOTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @GetMapping("/Find_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById (@PathVariable("empId") int empID) {
        Employee empData = null;
        empData = service.getEmployeePayrollDataById(empID);
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Get all employee ---------------------------------
    @GetMapping("/Show_All_Emp_Data")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        empDatalist = service.getEmployeeData();
        ResponseDTO respOTO = new ResponseDTO("Get Call Successful", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Edit employee data ---------------------------------
    @PutMapping("/Update_Employee_Data")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeeDTO employeeDTO) {
        Employee empData = null;
        empData = service.updateEmployeePayrollData(employeeDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete employee ---------------------------------
    @DeleteMapping("/Delete_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        service.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}

