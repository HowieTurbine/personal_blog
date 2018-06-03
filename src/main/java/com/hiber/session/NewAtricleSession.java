package com.hiber.session;

import com.hiber.model.ArticlesEntity;
import com.hiber.model.Identity;
import com.hiber.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class NewAtricleSession {

    private HibernateUtils Utils=new HibernateUtils();
    private Session session=Utils.getSession();



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
