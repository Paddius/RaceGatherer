/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author padde
 */
@Entity
public class User implements Serializable {
    
    @Id
    @Column(name="User_ID")
    @GeneratedValue
    private Long Id;
    private String name;
    private String pw;
    private String email;
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Collection<Driver> drivers = new ArrayList<Driver>();

    public User() {
    }

    public User(String name, String pw, String email) {
        this.name = name;
        this.pw = pw;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Collection<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Collection<Driver> drivers) {
        this.drivers = drivers;
    }
}
