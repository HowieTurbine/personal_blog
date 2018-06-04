package com.hiber.session;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hiber.model.ArticlesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleSession {
    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Autowired
    public ArticleSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
        transaction=session.beginTransaction();
    }

    public List<ArticlesEntity> selectAll() {
        Query query;
        {
            query = session.createQuery("from ArticlesEntity E order by E.time desc ");
        }
        List<ArticlesEntity> list;
        {
            list = query.list();
        }
        for(ArticlesEntity a:list)
        {
            System.out.println(a.getTime());
        }
        return list;
    }
    public ArticlesEntity select_with_id(int id) {
        System.out.println(id);
        Query query;
        {
            query = session.createQuery("from ArticlesEntity A where A.idA = "+id);
        }
        List<ArticlesEntity> list;
        {
            list = query.list();
        }
        for(ArticlesEntity a:list)
        {
            System.out.println(a.getTime());
        }
        System.out.println("Size: "+list.size());
        return list.get(0);
    }


}
