package com.ven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String single()
    {
        return "single.html";
    }
    @RequestMapping("/JTest")
    public String test(){return "JqueryTest.html";}
}



