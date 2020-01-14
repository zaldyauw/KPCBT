/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.dao;

import com.cbt.entity.Answer;
import com.cbt.entity.AnswerId;
import com.cbt.entity.Question;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AnswerDaoImpl implements DaoService<Answer> {

    @Override
    public int addData(Answer object) {
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

    public List<Answer> getAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Answer getOneData(Answer object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Answer> getSpecificData(Question object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(
                "from Answer where question_id = :id");
        query.setParameter("id", object.getId());
        List<Answer> result = query.list();
        return result;
    }

    @Override
    public int deleteData(Answer object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Answer> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Answer object) {
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
    
    public List<AnswerId> countAns(String type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Answer where id.id like concat('%',:id,'%')");
        query.setParameter("id", type);
        List<AnswerId> result = query.list();
        return result;
    }
}