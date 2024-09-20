package org.example.service;

import org.example.exception.ServiceException;
import org.example.model.ApplicationResponce;
import org.example.model.Error;
import org.example.model.LoginModel;
import org.example.model.ResistrationModel;
import org.example.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ApplicationResponce loginuser(LoginModel loginModel) throws ServiceException {
        Optional<ResistrationModel> userid = loginRepository.findById(loginModel.getUserId());
        List<Error> errorList = new ArrayList<>();
        if (userid.isPresent()) {
            ResistrationModel model = userid.get();
            if (model.getPassword().equals(loginModel.getPassWord())) {
                ApplicationResponce applicationResponce = new ApplicationResponce();
                applicationResponce.setData("Login SuccessFully");
                return applicationResponce;
            }
        } else {

            errorList.add(new Error("Wroung credential", "23"));
            ApplicationResponce applicationResponce = new ApplicationResponce();
            applicationResponce.setError(errorList);

        }
        throw new ServiceException(errorList);
    }

}
