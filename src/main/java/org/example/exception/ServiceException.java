package org.example.exception;

import org.example.model.Error;

import java.util.List;

public class ServiceException extends Exception{
    private List<Error> errormsg;

    public ServiceException(List<Error> errormsg) {
        this.errormsg = errormsg;
    }

    public List<Error> getErrormsg() {
        return errormsg;
    }
}
