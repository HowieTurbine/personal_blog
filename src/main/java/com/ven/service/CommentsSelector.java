package com.ven.service;

import com.hiber.model.CommentsEntity;
import com.hiber.session.CommentsSession;
import com.hiber.session.LoginSession;
import com.hiber.session.SignUpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CommentsSelector {
    private final CommentsSession commentsSession;
    private final ArticleSelector articleSelector;

    @Autowired
    public CommentsSelector(CommentsSession commentsSession, ArticleSelector articleSelector) {
        this.commentsSession = commentsSession;
        this.articleSelector = articleSelector;
    }

    public List<CommentsEntity> selector_by_article_id(int id)
    {
        List<CommentsEntity> list=commentsSession.select_with_article_id(id);
        if(list == null)
        {
            return null;
        }
        else
        {

            return list;
        }
    }    public Map<String,String> add(String username, String comment, int id_A) {
        Map<String, String> res = new HashMap<>();


            if (articleSelector.select_by_id((id_A+"")) != null) {
                res.put("Error", "No such article");
                return res;
            } else {
                return commentsSession.add(username,comment,id_A);
            }

    }
}
