package com.employeepayrollapplication.controller;

import com.employeepayrollapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpPayrollController {
    public static final String template = "Welcome To The Payroll App,%s";

    @Autowired
    public EmployeeService service;

    //--------------------------------- Get String Message ---------------------------------
    @RequestMapping("/welcome")
    public String displayMessage() {
        return service.employeeMessage();
    }
}
