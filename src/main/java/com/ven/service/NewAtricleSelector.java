package com.ven.service;

import com.hiber.session.NewAtricleSession;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

@Service
public class NewAtricleSelector {
    public Map<String,String> add(String title, String content, Timestamp time, String author)
    {
        NewAtricleSession session = new NewAtricleSession();
        return session.add_new_article(title,content,time,author);
    }
}
