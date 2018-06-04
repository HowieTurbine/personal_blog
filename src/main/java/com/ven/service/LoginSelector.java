package com.ven.service;

import com.hiber.model.UserEntity;
import com.hiber.session.LoginSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service()
public class LoginSelector {
    private final LoginSession session;

    @Autowired
    public LoginSelector(LoginSession session) {
        this.session = session;
    }

    public Map<String,String> check(String username, String password) {
        Map<String,String> res=new HashMap<>();
        res.put("Error","");
        res.put("Identity","");
        UserEntity res_entity = session.select_by_username(username);
        if (res_entity == null)
        {
            res.put("Error","No such user");
            return res;
        }
        else {
            if (!res_entity.getuPassword().equals(password)) {
                {
                    res.put("Error","Password Error");
                    return res;
                }
            } else
            {
                res.put("Identity",res_entity.getIdentity().toString());
                return res;
            }
        }
    }

    public List<UserEntity> allUser() {
        List<UserEntity> e = session.selectAll();
        return e;
    }

}
