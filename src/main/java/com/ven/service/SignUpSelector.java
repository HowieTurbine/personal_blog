package com.ven.service;

import com.hiber.session.SignUpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignUpSelector {
    private final SignUpSession session;

    @Autowired
    public SignUpSelector(SignUpSession session) {
        this.session = session;
    }

    public Map<String,String> add(String username,String password,String iCode) {
        Map<String, String> res = new HashMap<>();
        if (!iCode.equals(iCode)) {
            res.put("Error", "Wrong invitation code");
            return res;
        } else {
            if (session.select_by_username(username) != null) {
                res.put("Error", "Username already existed!");
                return res;
            } else {
                return session.add(username,password,iCode);
            }
        }
    }
}
