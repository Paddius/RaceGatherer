/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer;

import de.racegatherer.dao.TeamDAO;
import de.racegatherer.classes.Championship;
import de.racegatherer.classes.Driver;
import de.racegatherer.classes.Team;
import de.racegatherer.classes.User;
import de.racegatherer.dao.ChampionshipDAO;
import de.racegatherer.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;

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
        User dbtest = new User("dbtest", "test1234631", "test@test.de");
        UserDAO userDAO = new UserDAO();
        TeamDAO teamDAO = new TeamDAO();
        ChampionshipDAO csDAO = new ChampionshipDAO();

        // add 4 users
        userDAO.addUser(patrick);
        userDAO.addUser(dieter);
        userDAO.addUser(falko);
        userDAO.addUser(dbtest);
        
        // create teams        
        Team lotus = new Team("Lotus Racing");
        Team mclaren = new Team("McLaren");
        Team mercedes = new Team("Mercedes");
        Team ferrari = new Team("Ferrari");
        
        teamDAO.addTeam(lotus);
        teamDAO.addTeam(mclaren);
        teamDAO.addTeam(mercedes);
        teamDAO.addTeam(ferrari);
                
        // create championships 
        Championship pot = new Championship("pot meisterschaft 2011");
        Championship ht = new Championship("hottentottenliga");
        
        csDAO.addChampionship(ht);
        csDAO.addChampionship(pot);
        
        userDAO.joinChampionship(patrick, pot, lotus);
        userDAO.joinChampionship(falko, ht, mclaren);
        userDAO.joinChampionship(dieter, pot, ferrari);
        userDAO.joinChampionship(dbtest, ht, mercedes);
        
//        *** get all drivers for a user ***
//        User temp = userDAO.getUserByName("Patrick");
//        List<Driver> listOfDrivers =  userDAO.getDrivers(temp);
//        
//        for (Driver driver : listOfDrivers) {
//            System.out.println("Driver: " + driver.getId());
//        }
        
//        *** delete all users ***
//        List<User> users = userDAO.getUsers();
//        
//        for (User user : users) {
//            userDAO.deleteUser(user);
//        }
        
//        *** getUserByEmail test ***
//        System.out.println("name: " + userDAO.getUserByEmail("thepadde86@googlemail.com").getName());
        
//        *** getUserById test ***
//        patrick = userDAO.getUserById(new Long("1"));
//        System.out.println(patrick.getEmail());
        
        
//        *** list all users test ***        
//        ArrayList<User> list = (ArrayList<User>) userDAO.getUsers();
//        
//        for (User user : list) {
//            System.out.println("Name: " + user.getName() + " | Password: " 
//                    + user.getPw() + " | Email: " + user.getEmail());
//        }
        
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
