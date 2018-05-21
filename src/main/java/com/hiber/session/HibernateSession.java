package com.hiber.session;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hiber.model.ArticlesEntity;

import java.util.List;

public class HibernateSession {
    Configuration configuration=new Configuration().configure();
    SessionFactory sessionFactory=configuration.buildSessionFactory();
    Session session=sessionFactory.openSession();
    Transaction transaction=session.beginTransaction();
    public ArticlesEntity select() {
        Query query;
        {
            query = session.createQuery("from ArticlesEntity");
        }
        List<ArticlesEntity> list;
        {
            list = query.list();
        }
        for(ArticlesEntity a:list)
        {
            System.out.println(a.getTime());
        }
        return list.get(0);
    }


}
