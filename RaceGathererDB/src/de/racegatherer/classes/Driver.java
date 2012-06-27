/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.classes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author padde
 */
@Entity
public class Driver implements Serializable {
    
    @Id
    @GeneratedValue
    private Long Id;
    private Team team;
    private Championship cs;

    public Driver() {
    }

    public Driver(Team team, Championship cs) {
        this.team = team;
        this.cs = cs;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Championship getCs() {
        return cs;
    }

    public void setCs(Championship cs) {
        this.cs = cs;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
