/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.dao;

import de.racegatherer.utils.HibernateUtil;
import de.racegatherer.classes.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author padde
 */
public class DriverDAO {
    
    public void addDriver(Driver d) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();        
        session.save(d);
        transaction.commit();
    }
}
