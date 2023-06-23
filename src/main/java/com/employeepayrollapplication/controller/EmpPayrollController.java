package com.employeepayrollapplication.controller;

import com.employeepayrollapplication.dto.EmployeeDTO;
import com.employeepayrollapplication.dto.ResponseDTO;
import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.service.iEmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class EmpPayrollController {
    @Autowired
    iEmployeeService service;
    List<Employee> empDatalist = new ArrayList<>();

    //--------------------------------- Add employee ---------------------------------
    @PostMapping("/Register_Employee")
    public ResponseEntity<ResponseDTO> RegisterNewEmployee(
            @Valid @RequestBody EmployeeDTO empPayrollDTO) {
        Employee empData = service.RegisterEmployee(empPayrollDTO);
        ResponseDTO respOTO = new ResponseDTO("Register new employee successfully.", empData);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @GetMapping("/Find_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> FindEmployeeDataById(@PathVariable("empId") int empID) {
        Employee empData = service.FindEmployeeDataById(empID);
        ResponseDTO respDTO = new ResponseDTO("Employee data found successfully.", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Get all employee ---------------------------------
    @GetMapping("/Show_All_Emp_Data")
    public ResponseEntity<ResponseDTO> ShowAllEmployee() {
        empDatalist = service.ShowAllEmployee();
        ResponseDTO respOTO = new ResponseDTO("All employee data retrieved successfully.", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Edit employee data ---------------------------------
    @PutMapping("/Update_Employee_Data/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeeData(@PathVariable("empID") int empID, @RequestBody EmployeeDTO employeeDTO) {
        Employee empData = service.updateEmployeeData(empID, employeeDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated employee payroll data successfully.", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete employee ---------------------------------
    @DeleteMapping("/Delete_Employee_Data/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeeByeId(@PathVariable("empId") int empId) {
        service.deleteEmployeeByeId(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Get employee by department ---------------------------------
    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable String department) {
        List<Employee> empDataList = service.getEmployeesByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO(department + " Department employees", empDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}
