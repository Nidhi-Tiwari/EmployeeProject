package com.prepare.employee.util;

import com.prepare.employee.Exceptions.CustomExceptions;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class RequestParamValidator<T> {
    private Validator validator;

    public RequestParamValidator(Validator validator) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public void validate(T t) {
        if (t == null) {
            throw new CustomExceptions("Value cannot be null");
        }
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<T> violation : violations) {
            stringBuilder.append(violation.getMessage());
        }
        if (stringBuilder.length() != 0) {
            throw new CustomExceptions(stringBuilder.toString());
        }
    }
}
