package com.employeepayrollapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public @ToString class EmployeeDTO {
    @NotNull(message = "Employee Name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name Invalid")
    public String name;
    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;
    @Pattern(regexp = "Male|Female", message = "Gender needs to be Male or Female")
    public String gender;
    @NotNull(message = "startDate should Not be Empty")
    @JsonFormat(pattern = "dd MM yyyy")
    @PastOrPresent(message = "startDate should be past or present date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be Empty")
    public String note;
    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;
    @NotNull(message = "department should Not be Empty")
    public List<String> department;
}