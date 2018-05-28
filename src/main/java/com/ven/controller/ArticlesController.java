package com.ven.controller;

import com.hiber.model.ArticlesEntity;
import com.hiber.session.ArticleSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/query")
public class ArticlesController {
    //Query for all the articles
    @RequestMapping("/articles")
    @ResponseBody
    public List<ArticlesEntity> getAll()
    {
        ArticleSession session=new ArticleSession();
        List<ArticlesEntity> all=session.selectAll();
        if(all!=null)
            return all;
        else
            return new ArrayList<ArticlesEntity>();
    }
    @RequestMapping("/article")
    @ResponseBody
    public ArticlesEntity select_by_id(@RequestParam(value="id",required=true)String id)
    {
        //Query to the specific article by id
        ArticlesEntity selected;
        ArticleSession session=new ArticleSession();
        selected=session.select_with_id(Integer.valueOf(id));
        return selected;
    }
}
