/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Evgen Tkachuk
 */
@Entity(name="railway")
public class Railway implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column
    private Integer idRailway;
    private String railwayName;

    /**
     * @return the railwayId
     */
    public Integer getIdRailwayId() {
        return getIdRailway();
    }

    /**
     * @return the railwayName
     */
    public String getRailwayName() {
        return railwayName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the idRailway
     */
    public Integer getIdRailway() {
        return idRailway;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param idRailway the idRailway to set
     */
    public void setIdRailway(Integer idRailway) {
        this.idRailway = idRailway;
    }

    /**
     * @param railwayName the railwayName to set
     */
    public void setRailwayName(String railwayName) {
        this.railwayName = railwayName;
    }
}
