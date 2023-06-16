package com.employeepayrollapplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}$", message = "Employee name is incorrect")
    public String name;
    @NotEmpty(message = "Gender cannot be empty")
    public String gender;
    @NotEmpty(message = "Department cannot be empty")
    public String department;
    @Min(value = 500, message = "Salary should be minimum 500")
    public long salary;

}