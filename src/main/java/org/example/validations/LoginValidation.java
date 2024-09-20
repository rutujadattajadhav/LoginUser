package org.example.validations;

import org.example.exception.ValidationException;
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

    public void validate(LoginModel loginModel) throws ValidationException {
        List<Error> errorList=new ArrayList<>();
        if(Objects.isNull(loginModel)){
            errorList.add(new Error("Object is null","4"));
        }else{
            if(StringUtils.isEmpty(loginModel.getUserId())){
                errorList.add(new Error("Please fill the User Id","5"));
            }if(StringUtils.isEmpty(loginModel.getPassWord())){
                errorList.add(new Error("Please fill the  Password","6"));
            }
        }
        if(!errorList.isEmpty()){
          throw new ValidationException(errorList);
        }
    }
}
