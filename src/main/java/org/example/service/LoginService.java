package org.example.service;

import org.example.exception.ServiceException;
import org.example.handler.UserException;
import org.example.model.Error;
import org.example.model.LoginModel;
import org.example.repository.LoginRepository;
import org.example.response.ApplicationResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class LoginService extends ServiceException {
    @Autowired
    private LoginRepository loginRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public LoginService(List<Error> errormsg) {
        super(errormsg);
    }

    public Mono<ApplicationResponce> loginuser(LoginModel loginModel)  {
        ApplicationResponce applicationResponce  =new ApplicationResponce();
        return loginRepository.findById(loginModel.getEmail())
                .flatMap(user -> {
                    if (passwordEncoder.matches(loginModel.getPassWord(), user.getPassword())) {
                        applicationResponce.setData("Login Successfully");
                        return Mono.just(applicationResponce); }
                    else {
                        return Mono.error(new UserException("Wrong credential",231)); } })
                .switchIfEmpty(Mono.defer(() -> {
                    return Mono.error(new UserException("User not found",404));
                }));
    }

}
