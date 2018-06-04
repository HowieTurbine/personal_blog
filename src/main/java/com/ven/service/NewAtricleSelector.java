package com.ven.service;

import com.hiber.session.NewAtricleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

@Service
public class NewAtricleSelector {
    private NewAtricleSession session;

    @Autowired
    public NewAtricleSelector(NewAtricleSession session) {
        this.session = session;
    }

    public Map<String,String> add(String title, String content, Timestamp time, String author)
    {
        return session.add_new_article(title,content,time,author);
    }
}
