/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.dao;

import de.racegatherer.classes.Championship;
import de.racegatherer.classes.Driver;
import de.racegatherer.classes.Team;
import de.racegatherer.classes.User;
import de.racegatherer.utils.HibernateUtil;
import de.racegatherer.utils.PasswordEncoder;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author padde
 */
public class UserDAO {

    public void addUser(User u) {
        /* check if username or email already exists */
        if (getUserByName(u.getName()) == null && getUserByEmail(u.getEmail()) == null) {
            /* no user with this username or email exists -> create new user */
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            try {
                u.setPw(PasswordEncoder.getInstance().encode(u.getPw(), PasswordEncoder.getSalt()));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.save(u);
            transaction.commit();
        } else {
            Logger.getLogger(UserDAO.class.getName()).log(Level.INFO, "user already exists");
        }
    }

    public void updatePassword(User u, String newPW) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            u.setPw(PasswordEncoder.getInstance().encode(newPW, PasswordEncoder.getSalt()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void addDriver(User u, Driver d) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        u.getDrivers().add(d);
        session.saveOrUpdate(u);
        transaction.commit();
    }

    public List<Driver> getDrivers(User u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        u = (User) session.merge(u);
        List<Driver> drivers = (List<Driver>) u.getDrivers();
        return drivers;
    }

    public User getUserByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User where email = :email");
        query.setParameter("email", email);

        List resultList = query.list();
        if (resultList.size() > 0) {
            transaction.commit();
            return (User) resultList.listIterator().next();
        } else {
            transaction.commit();
            return null;
        }
    }
    
    public void deleteUser(User u) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();   
        session.delete(u);
        transaction.commit();
    }
    
    public void joinChampionship(User u, Championship c, Team t) {            
        DriverDAO driverDAO = new DriverDAO();
        UserDAO userDAO = new UserDAO();
        
        Driver temp_driver = new Driver(t);
        driverDAO.addDriver(temp_driver);
        userDAO.addDriver(u, temp_driver);
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction(); 
        
        if (c.getAdmins().isEmpty()) {
            c.getAdmins().add(temp_driver);
        }
        c.getDrivers().add(temp_driver);
        transaction.commit();
    }
}
