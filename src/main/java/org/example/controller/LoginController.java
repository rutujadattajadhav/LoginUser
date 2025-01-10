package org.example.controller;


import org.example.exception.ServiceException;
import org.example.exception.ValidationException;
import org.example.model.ApplicationResponce;
import org.example.model.Error;
import org.example.model.LoginModel;
import org.example.service.LoginService;
import org.example.validations.LoginValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class LoginController {
@Autowired
private LoginService loginService;

@Autowired
private LoginValidation loginValidation;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/loginUser")
    public ApplicationResponce loginUser(@RequestBody  LoginModel loginModel) {
        try {
            loginValidation.validate(loginModel);
            ApplicationResponce applicationResponce=  loginService.loginuser(loginModel);
            return applicationResponce;
        } catch (ValidationException validate) {
            ApplicationResponce applicationResponce = new ApplicationResponce();
            List<Error> errors = validate.getErrorMessage();
            applicationResponce.setError(errors);
            return applicationResponce;

        } catch (ServiceException e) {
            ApplicationResponce applicationResponce = new ApplicationResponce();
            List<Error> errors = e.getErrormsg();
            applicationResponce.setError(errors);
            return applicationResponce;
        }

    }
    @RequestMapping(value = "/testAPI")
    public String testAPI(){
        logger.info("Login test API");
        return "test success";
    }
}
