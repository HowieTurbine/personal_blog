package com.hiber.session;

import org.hibernate.*;

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
    }

    public List<ArticlesEntity> selectAll() {
        session = sessionFactory.openSession();
        session.clear();
        Query query = session.createQuery("from ArticlesEntity E order by E.time desc ");
        query.setCacheMode(CacheMode.IGNORE);
        List<ArticlesEntity> list;
        {
            list = query.list();
        }
        for(ArticlesEntity a:list)
        {
            System.out.println(a.getTime());
        }
        session.close();
        return list;
    }
    public ArticlesEntity select_with_id(int id) {
        System.out.println(id);
        session = sessionFactory.openSession();
        session.clear();
        Query query = session.createQuery("from ArticlesEntity A where A.idA = "+id);
        query.setCacheMode(CacheMode.IGNORE);
        List<ArticlesEntity> list;
        {
            list = query.list();
        }
        for(ArticlesEntity a:list)
        {
            System.out.println(a.getTime());
        }
        System.out.println("Size: "+list.size());
        session.close();
        return list.get(0);
    }


}
