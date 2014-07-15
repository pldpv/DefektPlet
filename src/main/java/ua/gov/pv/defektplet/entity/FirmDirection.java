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
@Entity(name = "firmDirection")
public class FirmDirection {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private Integer line;
    private Integer kmS;
    private Integer mS;
    private Integer kmE;
    private Integer mE;
    @ManyToOne
    @JoinColumn(name = "idDirection", referencedColumnName = "idDirection")
    private Direction direction;
   

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
  
    /**
     * @return the line
     */
    public Integer getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Integer line) {
        this.line = line;
    }

    /**
     * @return the kmS
     */
    public Integer getKmS() {
        return kmS;
    }

    /**
     * @param kmS the kmS to set
     */
    public void setKmS(Integer kmS) {
        this.kmS = kmS;
    }

    /**
     * @return the mS
     */
    public Integer getmS() {
        return mS;
    }

    /**
     * @param mS the mS to set
     */
    public void setmS(Integer mS) {
        this.mS = mS;
    }

    /**
     * @return the kmE
     */
    public Integer getKmE() {
        return kmE;
    }

    /**
     * @param kmE the kmE to set
     */
    public void setKmE(Integer kmE) {
        this.kmE = kmE;
    }

    /**
     * @return the mE
     */
    public Integer getmE() {
        return mE;
    }

    /**
     * @param mE the mE to set
     */
    public void setmE(Integer mE) {
        this.mE = mE;
    }
}
