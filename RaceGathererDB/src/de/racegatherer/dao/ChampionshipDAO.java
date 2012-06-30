/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.dao;

import de.racegatherer.classes.Championship;
import de.racegatherer.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author padde
 */
public class ChampionshipDAO {
    
    public void addChampionship(Championship c) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();        
        session.save(c);
        transaction.commit();
    }
    
}
