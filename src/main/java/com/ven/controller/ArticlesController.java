package com.ven.controller;

import com.hiber.model.ArticlesEntity;
import com.hiber.session.HibernateSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/query")
public class ArticlesController {
    @RequestMapping("/articles")
    @ResponseBody
    public List<ArticlesEntity> getAll()
    {
        HibernateSession session=new HibernateSession();
        List<ArticlesEntity> all=session.selectAll();
        if(all!=null)
            return all;
        else
            return new ArrayList<ArticlesEntity>();
    }
}
