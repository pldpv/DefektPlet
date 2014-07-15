/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 1
 */
@Embeddable
public class FirmId implements Serializable {

    @Column(name = "nameFirm")
    private String nameFirm;
    @ManyToOne
    @JoinColumn(name = "idRailway", referencedColumnName = "idRailway")
    private Railway railway;

    /**
     * @return the nameFirm
     */
    public String getNameFirm() {
        return nameFirm;
    }

    /**
     * @param nameFirm the nameFirm to set
     */
    public void setNameFirm(String nameFirm) {
        this.nameFirm = nameFirm;
    }

    /**
     * @return the railway
     */
    public Railway getRailway() {
        return railway;
    }

    /**
     * @param railway the railway to set
     */
    public void setRailway(Railway railway) {
        this.railway = railway;
    }



 
}