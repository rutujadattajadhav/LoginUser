package org.example.model;

public class Error {
    private String errorMessage;

    private String errrKey;

    public Error(String errorMessage, String errrKey) {
        this.errorMessage = errorMessage;
        this.errrKey = errrKey;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrrKey() {
        return errrKey;
    }
}
