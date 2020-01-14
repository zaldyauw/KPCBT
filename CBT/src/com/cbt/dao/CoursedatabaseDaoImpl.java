/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.dao;

import com.cbt.entity.Coursedatabase;
import com.cbt.entity.Subtest;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Zaldy Auw
 */
public class CoursedatabaseDaoImpl implements DaoService<Coursedatabase> {

    @Override
    public int addData(Coursedatabase object) {
        int result = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();

        return result;
    }

    @Override
    public int deleteData(Coursedatabase object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Coursedatabase> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Coursedatabase.class).setFetchMode("User", FetchMode.JOIN);
        List<Coursedatabase> coursedatabases = criteria.list();
        
        return coursedatabases;
    }

    @Override
    public int updateData(Coursedatabase object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Coursedatabase> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Coursedatabase.class);
        List<Coursedatabase> coursedatabases = criteria.list();
        session.close();

        return coursedatabases;
    }
    
}
