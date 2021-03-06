package com.hiber.session;

import com.hiber.model.ArticlesEntity;
import com.hiber.model.CommentsEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentsSession {
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public CommentsSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ArticlesEntity> selectAll() {
        session.clear();
        Query query;
        {
            query = session.createQuery("from CommentsEntity E order by E.time desc ");
        }
        List<ArticlesEntity> list;
        {
            list = query.list();
        }
        for(ArticlesEntity a:list)
        {
            System.out.println(a.getTime());
        }
        session.clear();
        return list;
    }
    public List<CommentsEntity> select_with_article_id(int id) {
        session = sessionFactory.openSession();
        session.clear();
        System.out.println(id);
        Query query;
        {
            query = session.createQuery("from CommentsEntity A where A.idA = "+id);
        }
        List<CommentsEntity> list;
        {
            list = query.list();
        }
        for(CommentsEntity a:list)
        {
        }
        System.out.println("Size: "+list.size());
        session.clear();
        session.close();
        return list;
    }
    public Map<String,String> add(String username, String comments, int id_A)
    {
        session = sessionFactory.openSession();
        session.clear();
        Map<String,String> res= new HashMap<>();
        CommentsEntity todo=new CommentsEntity();
        Transaction transaction = session.beginTransaction();
        todo.setUsername(username);
        todo.setCom(comments);
        todo.setIdA(id_A);
        //执行语句
        session.save(todo);
        //提交事务
        transaction.commit();
        res.put("Error","");
        session.clear();
        session.close();
        return res;
    }
}
