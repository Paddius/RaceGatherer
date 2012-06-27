/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer;

import de.racegatherer.classes.User;
import de.racegatherer.dao.UserDAO;
import java.util.ArrayList;

/**
 *
 * @author padde
 */
public class RaceGathererDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User patrick = new User("Patrick", "test123", "thepadde86@googlemail.com");
        User dieter = new User("Dieter", "gruetzidu", "dieter@dieterweb.de");
        User falko = new User("Falko", "habichnicht", "falko@balko.de");
        User mirco = new User("mirco", "nixPW", "m.kullack@kabelmail.de");
        UserDAO userDAO = new UserDAO();
        
        userDAO.addUser(patrick);
        userDAO.addUser(dieter);
        userDAO.addUser(falko);
        
//        *** getUserById test ***
//        patrick = userDAO.getUserById(new Long("1"));
//        System.out.println(patrick.getEmail());
        
        ArrayList<User> list = (ArrayList<User>) userDAO.getUsers();
        
        for (User user : list) {
            System.out.println("Name: " + user.getName() + " | Password: " 
                    + user.getPw() + " | Email: " + user.getEmail());
        }
        
//        userDAO.deleteUserById(new Long("1"));    
       
        
//        *** pw change test ***
//        User johndoe;
//        johndoe = userDAO.getUserByName("Patrick");
//        System.out.println(johndoe.getPw());
//        userDAO.updatePassword(johndoe, "123test");
//        johndoe = userDAO.getUserByName("Patrick");
//        System.out.println(johndoe.getPw());
    }
}
