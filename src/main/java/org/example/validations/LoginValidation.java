package org.example.validations;

import org.example.exception.ValidationException;
import org.example.handler.UserException;
import org.example.model.Error;
import org.example.model.LoginModel;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class LoginValidation extends ValidationException {

    public LoginValidation(List<Error> errorMessage) {
        super(errorMessage);
    }

    public void validate(LoginModel loginModel) throws ValidationException, UserException {

        if (Objects.isNull(loginModel)) {
            throw new UserException("Please fill the User Id and Password", 201);
        } else {
            if (StringUtils.isEmpty(loginModel.getEmail())) {
                throw new UserException("Please fill the User Id", 202);
            }
            if (StringUtils.isEmpty(loginModel.getPassWord())) {
                throw new UserException("Please fill the Password", 203);
            }

        }
    }
}