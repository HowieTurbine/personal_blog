package com.hiber.session;

import com.hiber.model.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginSession {
    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Autowired
    public LoginSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<UserEntity> selectAll() {
        session = sessionFactory.openSession();
        Query query;
        {
            query = session.createQuery("from UserEntity E ");
        }
        List<UserEntity> list;
        {
            list = query.list();
        }
        for(UserEntity a:list)
        {

        }
        session.close();
        return list;
    }
    public UserEntity select_by_username(String username)
    {
        session = sessionFactory.openSession();
        Query query;
        {
            System.out.println(username);
            query = session.createQuery("from UserEntity E where E.uName=\'"+ username+"\'");
        }
        List<UserEntity> list;
        {
            list = query.list();
        }
        session.clear();
            session.close();
        if(list.size()==0)
            return null;
        else
            return list.get(0);
    }

    public UserEntity select_by_id(int id)
    {
        session = sessionFactory.openSession();
        Query query;
        {
            System.out.println(id);
            query = session.createQuery("from UserEntity E where E.uName="+ id);
        }
        List<UserEntity> list;
        {
            list = query.list();
        }
        session.clear();
            session.close();
        if(list.size()==0)
            return null;
        else
            return list.get(0);
    }
}
