package com.ven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/main")
    public String main()
    {
        System.out.println("now");
        //return jsp的文件名就可以了跳到对应的jsp
        return  "index";
    }
    @RequestMapping("/contents")
    public String contents()
    {
        System.out.println("now");
        //return jsp的文件名就可以了跳到对应的jsp
        return  "contents";
    }
}



