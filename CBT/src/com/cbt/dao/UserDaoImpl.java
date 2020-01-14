package com.cbt.dao;

import com.cbt.entity.User;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nathan
 */
public class UserDaoImpl implements DaoService<User> {

    @Override
    public int addData(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(User object) {
        int result = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
            System.out.println("UP");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("RB");
        }
        session.close();

        return result;
    }

    public List<User> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User getOneData(User object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE username= :user AND password= :pass AND role_id= :role");
        query.setParameter("user", object.getUsername());
        query.setParameter("pass", object.getPassword());
        query.setParameter("role", object.getRole().getId());
        User result = (User) query.uniqueResult();
        return result;
    }

    @Override
    public int deleteData(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
