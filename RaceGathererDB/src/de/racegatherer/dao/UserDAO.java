/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.dao;

import de.racegatherer.HibernateUtil;
import de.racegatherer.classes.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author padde
 */
public class UserDAO {

    public void addUser(User u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(u);
        transaction.commit();
    }

    public void updatePassword(User u, String newPW) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        u.setPw(newPW);
        session.saveOrUpdate(u);
        transaction.commit();
    }

    /*
     * returns either the user with the given name or null if no user with this
     * name exists
     */
    public User getUserByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where name = :name");
        query.setParameter("name", name);

        List resultList = query.list();
        if (resultList.size() > 0) {
            transaction.commit();
            return (User) resultList.listIterator().next();
        } else {
            transaction.commit();
            return null;
        }

    }

    public User getUserById(Long Id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User u = (User) session.get(User.class, Id);
        transaction.commit();
        return u;
    }

    public void deleteUserById(Long Id) {
        User delUser = getUserById(Id);
        if (delUser != null) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.delete(delUser);
            transaction.commit();
        }

    }
    
    public List<User> getUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();        
        Query query = session.createQuery("from User");
        return query.list();
    }
}
