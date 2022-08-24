package com.ages.joinfut.Config.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tratamento de exceções que ocorrem nas requisições
 */
@RestControllerAdvice
public class PostValidationHandler {

    @Autowired
    private MessageSource messageSource;

    /**
     * Tratamento caso tenha um argumento não valido pelo POST
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorHandlerMessage> handle(MethodArgumentNotValidException exception) {
        List<ErrorHandlerMessage> errorHandlerMessages = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String mensagemErro = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorHandlerMessage erro = new ErrorHandlerMessage(e.getField(), mensagemErro);
            errorHandlerMessages.add(erro);
        });
        return errorHandlerMessages;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException constraintViolationException, WebRequest webRequest) {
        List<String> erros = new ArrayList<String>();
        for (ConstraintViolation<?> violation : constraintViolationException.getConstraintViolations()) {
            erros.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + " : " + violation.getMessage());
        }
        ErrorHandlerMessage errorHandlerMessage = new ErrorHandlerMessage(HttpStatus.BAD_REQUEST, constraintViolationException.getLocalizedMessage(), erros);
        return new ResponseEntity<Object>(errorHandlerMessage, new HttpHeaders(), errorHandlerMessage.getStatus());
    }
}
