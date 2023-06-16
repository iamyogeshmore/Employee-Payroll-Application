package com.employeepayrollapplication.controller;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.dto.ResponseDTO;
import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.service.EmployeeService;
import com.employeepayrollapplication.service.iEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpPayrollController {
    @Autowired
    iEmployeeService service;
    List<Employee> empDatalist = new ArrayList<>();

    //--------------------------------- Add employee ---------------------------------
    @PostMapping("/Register_Employee")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
            @Valid @RequestBody EmployeeDTO empPayrollDTO) {
        Employee empData = service.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respOTO = new ResponseDTO("Register new employee successfully.", empData);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @GetMapping("/Find_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empID) {
        Employee empData = service.getEmployeePayrollDataById(empID);
        ResponseDTO respDTO = new ResponseDTO("Get call for Id successful.", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Get all employee ---------------------------------
    @GetMapping("/Show_All_Emp_Data")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        empDatalist = service.getEmployeeData();
        ResponseDTO respOTO = new ResponseDTO("Get call successful.", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Edit employee data ---------------------------------
    @PutMapping("/Update_Employee_Data/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empID") int empID, @RequestBody EmployeeDTO employeeDTO) {
        Employee empData = service.updateEmployeePayrollData(empID, employeeDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated employee payroll data successfully.", empData);
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

