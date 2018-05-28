package com.ven.service;

import com.hiber.model.LoginEntity;
import com.hiber.session.LoginSession;
import org.springframework.stereotype.Service;

@Service()
public class LoginCheck
        {
        public String check(String username,String password)
        {
            LoginSession session = new LoginSession();
            LoginEntity res = session.select_by_username(username);
            if(res==null)
                return "No such user";
            else
            {
                if(!res.getuPassword().equals(password))
                {
                    return "Password Error";
                }
                else
                    return res.getIdentity().toString();
            }
        }

}
