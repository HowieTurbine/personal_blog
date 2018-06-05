package com.ven.controller;

import com.hiber.model.ArticlesEntity;
import com.hiber.session.ArticleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ven.service.ArticleSelector;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/query")
public class ArticlesController {
private final ArticleSelector selector;

    @Autowired
    public ArticlesController(ArticleSelector selector) {
        this.selector = selector;
    }


    //Query for all the articles
    @RequestMapping("/articles")
    @ResponseBody
    public List<ArticlesEntity> getAll() {
        return selector.getAll();
    }

    @RequestMapping("/article")
    @ResponseBody
    public ArticlesEntity select_by_id(@RequestParam(value = "id", required = true) int id) {
        return selector.select_by_id(id);
    }
}
