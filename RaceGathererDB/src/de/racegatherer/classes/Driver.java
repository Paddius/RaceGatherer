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
}
