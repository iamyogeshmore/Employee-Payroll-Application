package com.employeepayrollapplication.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    public String name;
    public String gender;
    public String department;
    public long salary;

}