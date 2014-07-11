/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author ПГМ
 */
@Entity
public class Direction implements Serializable {
   @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer idDirection;
    private String nameDirection;
    private Integer line;
    private Integer kmS;
    private Integer mS;
    private Integer kmE;
    private Integer mE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getKmS() {
        return kmS;
    }

    public void setKmS(Integer kmS) {
        this.kmS = kmS;
    }

    public Integer getmS() {
        return mS;
    }

    public void setmS(Integer mS) {
        this.mS = mS;
    }

    public Integer getKmE() {
        return kmE;
    }

    public void setKmE(Integer kmE) {
        this.kmE = kmE;
    }

    public Integer getmE() {
        return mE;
    }

    public void setmE(Integer mE) {
        this.mE = mE;
    }

    /**
     * @return the idDirection
     */
    public Integer getIdDirection() {
        return idDirection;
    }

    /**
     * @param idDirection the idDirection to set
     */
    public void setIdDirection(Integer idDirection) {
        this.idDirection = idDirection;
    }

    /**
     * @return the nameDirection
     */
    public String getNameDirection() {
        return nameDirection;
    }

    /**
     * @param nameDirection the nameDirection to set
     */
    public void setNameDirection(String nameDirection) {
        this.nameDirection = nameDirection;
    }
}
