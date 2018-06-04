package com.hiber.session;

import com.hiber.model.ArticlesEntity;
import com.hiber.model.Identity;
import com.hiber.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
@Service
public class NewAtricleSession {

    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Autowired
    public NewAtricleSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
    }



    public Map<String,String> add_new_article(String title, String content, Timestamp time, String author)
    {
        Map<String,String> res= new HashMap<>();

        ArticlesEntity todo=new ArticlesEntity();
       todo.setAuthor(author);
       todo.setTime(time);
       todo.setTitle(title);
       todo.setContent(content);
        //开始事务
        Transaction tran = session.beginTransaction();
        //执行语句
        session.save(todo);
        //提交事务
        tran.commit();
        res.put("Error","");
        return res;
    }

}
