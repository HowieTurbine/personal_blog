package com.ven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/main")
    public String main()
    {
        System.out.println("now");
        return  "index.html";
    }
    @RequestMapping("/contents")
    public String contents()
    {
        return  "contents.html";
    }
    @RequestMapping("/single")
    public String single(@RequestParam(value="id",required=true)String id)
    {
        return "single.html";
    }
    @RequestMapping("/Login")
    public String login()
    {
        return "login.html";
    }
    @RequestMapping("/SignUp")
    public String SignUp()
    {
        return "sign_up.html";
    }
}



