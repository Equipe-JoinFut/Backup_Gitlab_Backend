package com.ages.joinfut.config.validation;

public class ErrorHandlerMessage {

    private String status;
    private String error;

    public ErrorHandlerMessage(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
