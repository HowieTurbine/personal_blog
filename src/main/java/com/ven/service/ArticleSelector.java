package com.ven.service;

import com.hiber.model.ArticlesEntity;
import com.hiber.session.ArticleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleSelector {
    private final ArticleSession session;

    @Autowired
    public ArticleSelector(ArticleSession session) {
        this.session = session;
    }

    public List<ArticlesEntity> getAll()
    {
        List<ArticlesEntity> all=session.selectAll();
        if(all!=null)
            return all;
        else
            return new ArrayList<ArticlesEntity>();
    }
    public ArticlesEntity select_by_id(@RequestParam(value="id",required=true)int id)
    {
        //Query to the specific article by id
        ArticlesEntity selected;
        selected=session.select_with_id(id);
        return selected;
    }
}
