package com.ven.service;

import com.hiber.model.LoginEntity;
import com.hiber.session.LoginSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class LoginSelector {
    public String check(String username, String password) {
        LoginSession session = new LoginSession();
        LoginEntity res = session.select_by_username(username);
        if (res == null)
            return "No such user";
        else {
            if (!res.getuPassword().equals(password)) {
                return "Password Error";
            } else
                return res.getIdentity().toString();
        }
    }

    public List<LoginEntity> allUser() {
        LoginSession session = new LoginSession();
        List<LoginEntity> e = session.selectAll();
        return e;
    }

}
