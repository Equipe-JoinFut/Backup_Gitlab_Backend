package com.ages.joinfut.Config.Validations;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ErrorHandlerMessage {

    private HttpStatus status;
    private String campoProblema;
    private String erro;
    private List<String> erros;

    public ErrorHandlerMessage(HttpStatus status, String campoProblema, List<String> erros) {
        this.status = status;
        this.campoProblema = campoProblema;
        this.erros = erros;
    }

    public ErrorHandlerMessage(String campoProblema, String erro) {
        this.campoProblema = campoProblema;
        this.erro = erro;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCampoProblema() {
        return campoProblema;
    }

    public String getErro() {
        return erro;
    }

    public List<String> getErros() {
        return erros;
    }
}
