package com.employeepayrollapplication.exception;

import com.employeepayrollapplication.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@ControllerAdvice
public class CustomException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errormessage = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO respDTO = new ResponseDTO("Exception while processing rest request",errormessage);
        return new ResponseEntity<>(respDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
        ResponseDTO respDTO = new ResponseDTO("Exception while processing REST request",
                exception.getMessage());
        return new ResponseEntity<>(respDTO, HttpStatus.BAD_REQUEST);
    }

    private static final String message=  "Exception while processing REST Request";
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format", exception);
        ResponseDTO responseDTO = new ResponseDTO(message,
                "Should have date in the Format dd MMM yyyy");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}