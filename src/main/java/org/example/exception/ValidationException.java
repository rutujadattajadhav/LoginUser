package org.example.exception;

import org.example.model.Error;

import java.util.List;

public class ValidationException extends Exception{
    private List<Error> errorMessage;

    public ValidationException( List<Error> errorMessage) {

        this.errorMessage = errorMessage;
    }

    public List<Error> getErrorMessage() {
        return errorMessage;
    }

}
