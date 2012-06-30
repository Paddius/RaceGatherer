/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author padde
 */
@Entity
public class Championship implements Serializable {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Collection<Driver> admins = new ArrayList<Driver>();
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Collection<Driver> drivers = new ArrayList<Driver>();
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Collection<Track> races = new ArrayList<Track>();

    public Championship() {
    }

    public Championship(String name) {
        this.name = name;
    }    

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Collection<Driver> getAdmins() {
        return admins;
    }

    public void setAdmins(Collection<Driver> admins) {
        this.admins = admins;
    }

    public Collection<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Collection<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Track> getRaces() {
        return races;
    }

    public void setRaces(Collection<Track> races) {
        this.races = races;
    }
}
