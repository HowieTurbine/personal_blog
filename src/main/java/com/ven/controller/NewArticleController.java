package com.ven.controller;

import com.hiber.session.NewAtricleSession;
import com.ven.service.NewAtricleSelector;
import com.ven.service.SignUpSelector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Map;

@Controller
@RequestMapping("/NewArticle")
public class NewArticleController {
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> New(@RequestParam(value="title",required = false) String title,
                                     @RequestParam(value="time",required = false)Timestamp time,
                                     @RequestParam(value="content",required = false) String content,
                                     @RequestParam(value="author",required = false) String author)
    {

        NewAtricleSelector selector = new NewAtricleSelector();
        return selector.add(title,content,time,author);
    }
}
