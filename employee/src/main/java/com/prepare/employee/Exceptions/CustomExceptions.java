package com.prepare.employee.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomExceptions extends RuntimeException {

    private static final long serialVersionUID = 1l;

    public CustomExceptions(String message) {
        super(message);
    }

}
