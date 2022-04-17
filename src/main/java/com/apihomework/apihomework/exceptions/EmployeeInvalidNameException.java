package com.apihomework.apihomework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidNameException extends RuntimeException{
        public EmployeeInvalidNameException(String name) {
            super("Invalid name " + name);
        }
    }
