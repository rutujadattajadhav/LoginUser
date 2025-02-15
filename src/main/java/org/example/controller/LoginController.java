package org.example.controller;


import org.example.exception.ValidationException;
import org.example.handler.UserException;
import org.example.model.LoginModel;
import org.example.response.ApplicationResponce;
import org.example.service.LoginService;
import org.example.validations.LoginValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
public class LoginController {
@Autowired
private LoginService loginService;

@Autowired
private LoginValidation loginValidation;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/loginUser")
    public Mono<ApplicationResponce> loginUser(@RequestBody  LoginModel loginModel) throws ValidationException, UserException {
            loginValidation.validate(loginModel);
            return   loginService.loginuser(loginModel);
    }

    @RequestMapping(value = "/testAPI")
    public String testAPI(){
        logger.info("Login test API");
        return "test success";
    }
}
