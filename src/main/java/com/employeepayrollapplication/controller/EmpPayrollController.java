package com.employeepayrollapplication.controller;

import com.employeepayrollapplication.model.Employee;
import com.employeepayrollapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //--------------------------------- Add employee ---------------------------------

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployees(employee);
    }

    //--------------------------------- Get employee by id ---------------------------------
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return service.findEmployeeById(id);
    }

    //--------------------------------- Get all employee ---------------------------------
    @GetMapping("/allEmployees")
    public List<Employee> findAllEmployees() {
        return service.findEmployees();
    }

    //--------------------------------- Edit employee data ---------------------------------
    @PutMapping("/editEmployee/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return service.editEmployee(employee, id);
    }

    //--------------------------------- Delete employee ---------------------------------
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return "Data Deleted";
    }
}

