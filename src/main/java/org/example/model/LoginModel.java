package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {
    private String email;
    private String passWord;

    public String getEmail() {
        return email;
    }

    public void setEmail(String userId) {
        this.email = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
