/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.dao;

import de.racegatherer.classes.Team;
import de.racegatherer.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author padde
 */
public class TeamDAO {
    public void addTeam(Team t) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();        
        session.save(t);
        transaction.commit();
    }    
}
