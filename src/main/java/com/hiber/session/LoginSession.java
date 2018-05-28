package com.hiber.session;

import com.hiber.model.LoginEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LoginSession {
    private HibernateUtils Utils=new HibernateUtils();;
    private Session session=Utils.getSession();
    private Transaction transaction=session.beginTransaction();

    public List<LoginEntity> selectAll() {
        Query query;
        {
            query = session.createQuery("from LoginEntity E ");
        }
        List<LoginEntity> list;
        {
            list = query.list();
        }
        for(LoginEntity a:list)
        {

        }
        return list;
    }
    public LoginEntity select_by_username(String username)
    {
        Query query;
        {
            System.out.println(username);
            query = session.createQuery("from LoginEntity E where E.uName=\'"+ username+"\'");
        }
        List<LoginEntity> list;
        {
            list = query.list();
        }
        return list.get(0);

    }
}
