/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.dao;

import com.cbt.entity.Statusdetail;
import com.cbt.entity.User;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Zaldy Auw
 */
public class StatusDaoImpl implements DaoService<Statusdetail>{

    @Override
    public int addData(Statusdetail object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Statusdetail object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Statusdetail> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Statusdetail object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Statusdetail> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Statusdetail.class);
        List<Statusdetail> statusdetails = criteria.list();
        session.close();

        return statusdetails;
    }
      public Statusdetail getOneData(User object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Statusdetail WHERE user_id= :id");
        query.setParameter("id", object.getId());
        Statusdetail result = (Statusdetail) query.uniqueResult();
        return result;
    }
    
}
