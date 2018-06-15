package com.hiber.session;

import com.hiber.model.Identity;
import com.hiber.model.UserEntity;
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
public class SignUpSession {

    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public SignUpSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private String iCode ="1234";

    public UserEntity select_by_username(String username)
    {
        return new LoginSession(sessionFactory).select_by_username(username);
    }
    public Map<String,String> add(String username,String password,String iCode)
    {
        session = sessionFactory.openSession();
        session.clear();
        Map<String,String> res= new HashMap<>();

                UserEntity todo=new UserEntity();
                todo.setuName(username);
                todo.setuPassword(password);
                todo.setIdentity(Identity.user);
                //开始事务
                Transaction tran = session.beginTransaction();
                //执行语句
                session.save(todo);
                //提交事务
                tran.commit();
                res.put("Error","");
        session.clear();
        session.close();
                return res;
    }


}
