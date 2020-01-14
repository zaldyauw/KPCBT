package com.cbt.dao;

import com.cbt.entity.Subtest;
import com.cbt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author nathan
 */
public class SubtestDaoImpl implements DaoService<Subtest> {

    @Override
    public int addData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Subtest> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Subtest.class);
        List<Subtest> subtests = criteria.list();
        session.close();

        return subtests;
    }

    @Override
    public int deleteData(Subtest object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subtest> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
