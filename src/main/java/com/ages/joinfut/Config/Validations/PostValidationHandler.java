package com.ages.joinfut.Config.Validations;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class PostValidationHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException constraintViolationException) {
        List<String> erros = new ArrayList<>();
        for (ConstraintViolation<?> violation : constraintViolationException.getConstraintViolations()) {
            erros.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + " : " + violation.getMessage());
        }
        ErrorHandlerMessage errorHandlerMessage = new ErrorHandlerMessage(HttpStatus.BAD_REQUEST, erros);
        return new ResponseEntity<>(errorHandlerMessage, new HttpHeaders(), errorHandlerMessage.getStatus());
    }
}
