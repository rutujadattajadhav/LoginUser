package org.example.handler;

public class UserErrorResponse {
    private CustomErrorResponse error;

    public UserErrorResponse(CustomErrorResponse error) {
        this.error = error;
    }

    public CustomErrorResponse getError() {
        return error;
    }

    public void setError(CustomErrorResponse error) {
        this.error = error;
    }
}
