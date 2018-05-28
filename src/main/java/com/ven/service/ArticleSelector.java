package com.ven.service;

import com.hiber.model.ArticlesEntity;
import com.hiber.session.ArticleSession;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleSelector {
    public List<ArticlesEntity> getAll()
    {
        ArticleSession session=new ArticleSession();
        List<ArticlesEntity> all=session.selectAll();
        if(all!=null)
            return all;
        else
            return new ArrayList<ArticlesEntity>();
    }
    public ArticlesEntity select_by_id(@RequestParam(value="id",required=true)String id)
    {
        //Query to the specific article by id
        ArticlesEntity selected;
        ArticleSession session=new ArticleSession();
        selected=session.select_with_id(Integer.valueOf(id));
        return selected;
    }
}
