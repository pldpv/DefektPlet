/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 1
 */
@Entity(name = "railway_direction")
public class RailwayDirection implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    @ManyToOne
    @JoinColumn(name = "idDirection", referencedColumnName = "idDirection")
    private Direction direction;
    @ManyToOne
    @JoinColumn(name = "idRailway", referencedColumnName = "idRailway")
    private Railway railway;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return the railway
     */
    public Railway getRailway() {
        return railway;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @param railway the railway to set
     */
    public void setRailway(Railway railway) {
        this.railway = railway;
    }
}