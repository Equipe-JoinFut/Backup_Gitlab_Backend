package com.ages.joinfut.Config.Validations;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ErrorHandlerMessage {

    private HttpStatus status;
    private List<String> erros;

    public ErrorHandlerMessage(HttpStatus status,List<String> erros) {
        this.status = status;
        this.erros = erros;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErros() {
        return erros;
    }
}
