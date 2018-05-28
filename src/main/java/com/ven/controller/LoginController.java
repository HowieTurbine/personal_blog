package com.ven.controller;

import com.hiber.model.LoginEntity;
import com.hiber.session.LoginSession;
import com.ven.service.LoginCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RequestMapping("/user")
@Controller
public class LoginController {

    private LoginCheck loginCheck;

    @RequestMapping("/allUser")
    @ResponseBody
    public List<LoginEntity> allUser()
    {
        LoginSession session=new LoginSession();
        List<LoginEntity> e=session.selectAll();
        return e;
    }

    public LoginController()
    {
        loginCheck=new LoginCheck();
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value="username",required = true)String username,
                        @RequestParam(value="password",required = true) String password)
    {
        return loginCheck.check(username,password);
    }
}
