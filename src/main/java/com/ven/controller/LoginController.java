package com.ven.controller;

import com.hiber.model.LoginEntity;
import com.hiber.session.LoginSession;
import com.ven.service.LoginSelector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RequestMapping("/user")
@Controller
public class LoginController {

    private LoginSelector loginSelector;
    public LoginController()
    {
        loginSelector =new LoginSelector();
    }
    @RequestMapping("/allUser")
    @ResponseBody
    public List<LoginEntity> allUser()
    {
        return loginSelector.allUser();
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value="username",required = true)String username,
                        @RequestParam(value="password",required = true) String password)
    {
        return loginSelector.check(username,password);
    }
}
