/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;

import javax.persistence.*;

/**
 *
 * @author 1
 */
@Entity(name="firmDirection")
public class FirmDirection {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "idDirection", referencedColumnName = "idDirection")
    private Direction direction;
    @ManyToOne
    @JoinColumn(name = "idFirm", referencedColumnName = "idFirm")
    private RailwayFirm railwayFirm;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the railwayFirm
     */
    public RailwayFirm getRailwayFirm() {
        return railwayFirm;
    }

    /**
     * @param railwayFirm the railwayFirm to set
     */
    public void setRailwayFirm(RailwayFirm railwayFirm) {
        this.railwayFirm = railwayFirm;
    }
}
