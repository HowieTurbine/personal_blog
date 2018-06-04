package com.ven.controller;

import com.ven.service.SignUpSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/user")
@Controller
public class SignUpController {
private SignUpSelector selector;

    @Autowired
    public SignUpController(SignUpSelector selector) {
        this.selector = selector;
    }

    @RequestMapping(value = "/SignUp",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> SignUp(@RequestParam(value="username",required = false) String username,
                                     @RequestParam(value="password",required = false) String password,
                                     @RequestParam(value="iCode",required = false) String iCode)
    {

        return selector.add(username,password,iCode);
    }
}
