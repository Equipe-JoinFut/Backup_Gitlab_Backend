package com.ages.joinfut.Config.Validations;

public class ErrorHandlerMessage {

    private String campoProblema;
    private String erro;

    public ErrorHandlerMessage(String campoProblema, String erro) {
        this.campoProblema = campoProblema;
        this.erro = erro;
    }

    public String getCampoProblema() {
        return campoProblema;
    }

    public String getErro() {
        return erro;
    }
}
