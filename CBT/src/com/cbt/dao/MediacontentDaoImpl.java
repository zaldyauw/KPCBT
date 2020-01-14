/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.dao;

import com.cbt.entity.Mediacontent;
import com.cbt.entity.Question;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Zaldy Auw
 */
public class MediacontentDaoImpl implements DaoService<Mediacontent>{

    @Override
    public int addData(Mediacontent object) {
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
    public int deleteData(Mediacontent object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mediacontent> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Mediacontent object) {
        int result = 0;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();

        return result;
    }
    
    public List<Mediacontent> getSpecificData(int type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Mediacontent where media_id like concat('%',:id,'%')");
        query.setParameter("id", type);
        List<Mediacontent> result = query.list();
        return result;
    }
    
}
