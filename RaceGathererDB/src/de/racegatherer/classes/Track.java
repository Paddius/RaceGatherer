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
public class Track implements Serializable {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private int duration;
    private String country;

    public Track() {
    }

    public Track(String name, int duration, String country) {
        this.name = name;
        this.duration = duration;
        this.country = country;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
    
}
