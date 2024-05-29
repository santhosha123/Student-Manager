package com.example.demo.error;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorHandler
{
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    public String studentNotFoundException()
    {
        return "No student exists";
    }
}
