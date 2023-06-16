package com.employeepayrollapplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    @NotNull(message = "Employee Name Cannot be Null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}$", message = "Employee Name is Incorrect")
    public String name;
    @NotEmpty(message = "Gender Cannot be empty")
    public String gender;
    @NotEmpty(message = "Department Cannot be empty")
    public String department;
    @Min(value = 500, message = "Salary Should be minimum 500")
    public long salary;

    @NotEmpty(message = "profilePic Cannot Be Empty.")
    public String profilePic;

    @NotEmpty(message = "note Cannot Be Empty.")
    public String note;

    public String startDate;
}