package com.hiber.session;

import com.hiber.model.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LoginSession {
    private HibernateUtils Utils=new HibernateUtils();
    private Session session=Utils.getSession();
    private Transaction transaction=session.beginTransaction();

    public List<UserEntity> selectAll() {
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
        return list;
    }
    public UserEntity select_by_username(String username)
    {
        Query query;
        {
            System.out.println(username);
            query = session.createQuery("from UserEntity E where E.uName=\'"+ username+"\'");
        }
        List<UserEntity> list;
        {
            list = query.list();
        }
        if(list.size()==0)
            return null;
        else
            return list.get(0);

    }
}
