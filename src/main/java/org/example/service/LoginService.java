package org.example.service;

import org.example.exception.ServiceException;
import org.example.model.ApplicationResponce;
import org.example.model.Error;
import org.example.model.LoginModel;
import org.example.model.ResistrationModel;
import org.example.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService extends ServiceException {
    @Autowired
    private LoginRepository loginRepository;

    public LoginService(List<Error> errormsg) {
        super(errormsg);
    }

    public Mono<ApplicationResponce> loginuser(LoginModel loginModel) throws ServiceException {
        List<Error> errorList = new ArrayList<>();
        return loginRepository.findById(loginModel.getUserId())
                .flatMap(user -> {
                    if (user.getPassword().equals(loginModel.getPassWord())) {
                        ApplicationResponce applicationResponse = new ApplicationResponce();
                        applicationResponse.setData("Login Successfully");
                        return Mono.just(applicationResponse); }
                    else {
                        errorList.add(new Error("Wrong credential", "23"));
                        ApplicationResponce applicationResponse = new ApplicationResponce();
                        applicationResponse.setError(errorList); return Mono.error(new ServiceException(errorList)); } })
                .switchIfEmpty(Mono.defer(() -> {
                    errorList.add(new Error("User not found", "404"));
                    return Mono.error(new ServiceException(errorList));
                }));
    }

}
