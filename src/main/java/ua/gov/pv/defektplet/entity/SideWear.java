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
import org.hibernate.annotations.Formula;

/**
 *
 * @author Tkachuk Evgen
 */
@Entity(name = "sideWear")
public class SideWear implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String railway;

    public SideWear() {
    }

    public SideWear(String railway, Integer firm, String direction, Integer line, String runnungLine,Integer limb, Integer kmS, Integer pK,  Float insideSideWear, Float outsideSideWear) {
        this.railway = railway;
        this.direction = direction;
        this.firm = firm;
        this.line = line;
        this.railThread = runnungLine;
        this.kmS = kmS;
        this.pK = pK;
        this.limb = limb;
        this.insideSideWear = insideSideWear;
        this.outsideSideWear = outsideSideWear;
    }
    private String direction;
    private Integer firm;
    private Integer line;
    private String railThread;
    private Integer kmS;
    private Integer pK;
    private Integer limb;
    private Float insideSideWear;
    private Float outsideSideWear;
    @Formula("kmS*1000+pK*100+1-100+limb*25-25")
    private Integer startCoordinate;
    @Formula("kmS*1000+pK*100+1-100+limb*25")
    private Integer endCoordinate;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the railway
     */
    public String getRailway() {
        return railway;
    }

    /**
     * @param railway the railway to set
     */
    public void setRailway(String railway) {
        this.railway = railway;
    }

    /**
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * @return the firm
     */
    public Integer getFirm() {
        return firm;
    }

    /**
     * @param firm the firm to set
     */
    public void setFirm(Integer firm) {
        this.firm = firm;
    }

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
     * @return the runnungLine
     */
    public String getRailThread() {
        return railThread;
    }

    /**
     * @param runnungLine the runnungLine to set
     */
    public void setRailsThread(String railThread) {
        this.railThread = railThread;
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
     * @return the pK
     */
    public Integer getpK() {
        return pK;
    }

    /**
     * @param pK the pK to set
     */
    public void setpK(Integer pK) {
        this.pK = pK;
    }

    /**
     * @return the limb
     */
    public Integer getLimb() {
        return limb;
    }

    /**
     * @param limb the limb to set
     */
    public void setLimb(Integer limb) {
        this.limb = limb;
    }

    /**
     * @return the insideSideWear
     */
    public Float getInsideSideWear() {
        return insideSideWear;
    }

    /**
     * @param insideSideWear the insideSideWear to set
     */
    public void setInsideSideWear(Float insideSideWear) {
        this.insideSideWear = insideSideWear;
    }

    /**
     * @return the outsideSideWear
     */
    public Float getOutsideSideWear() {
        return outsideSideWear;
    }

    /**
     * @param outsideSideWear the outsideSideWear to set
     */
    public void setOutsideSideWear(Float outsideSideWear) {
        this.outsideSideWear = outsideSideWear;
    }

    /**
     * @return the startCoordinate
     */
    public Integer getStartCoordinate() {
        return startCoordinate;
    }

    /**
     * @param startCoordinate the startCoordinate to set
     */
    public void setStartCoordinate(Integer startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    /**
     * @return the endCoordinate
     */
    public Integer getEndCoordinate() {
        return endCoordinate;
    }

    /**
     * @param endCoordinate the endCoordinate to set
     */
    public void setEndCoordinate(Integer endCoordinate) {
        this.endCoordinate = endCoordinate;
    }
}
