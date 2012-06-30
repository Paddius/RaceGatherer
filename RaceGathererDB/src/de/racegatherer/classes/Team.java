/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.racegatherer.classes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author padde
 */
@Entity
public class Team implements Serializable {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;

    public Team() {
    }
    
    public Team(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }    

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
