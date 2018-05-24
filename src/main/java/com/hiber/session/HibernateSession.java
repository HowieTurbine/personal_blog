package com.hiber.session;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hiber.model.ArticlesEntity;

import java.util.List;

public class HibernateSession {
    private Configuration configuration=new Configuration().configure();
    private SessionFactory sessionFactory=configuration.buildSessionFactory();
    private Session session=sessionFactory.openSession();
    private Transaction transaction=session.beginTransaction();
    public List<ArticlesEntity> selectAll() {
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
