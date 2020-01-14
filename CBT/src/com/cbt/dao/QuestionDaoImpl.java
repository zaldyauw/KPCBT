/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.dao;

import com.cbt.entity.Coursedatabase;
import com.cbt.entity.Question;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Zaldy Auw
 */
public class QuestionDaoImpl implements DaoService<Question> {

    @Override
    public int addData(Question object) {
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
    public int deleteData(Question object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Question object) {
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

    public List<Question> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Question.class);
        List<Question> questions = criteria.list();
        session.close();

        return questions;
    }

    public List<Question> getSpecificData(Coursedatabase object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Question where coursedatabase_id= :id");
        query.setParameter("id", object.getId());
        List<Question> result = query.list();
        return result;

    }
    
    public List<Question> getCount(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Question where id like concat('%',:id,'%')");
        query.setParameter("id", type);
        List<Question> result = query.list();
        return result;

    }
    
}
