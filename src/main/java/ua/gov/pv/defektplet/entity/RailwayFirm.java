/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;


import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Formula;
/**
 *
 * @author 1
 */
@Entity(name="firm")
public class RailwayFirm implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String nameFirm;
    private String fullName;
    private String director;
    @ManyToOne
    @JoinColumn(name ="idRailway", referencedColumnName="idRailway")
    private Railway railway;
    @Formula("idRailway+nameFirm")
    private String idFirm;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFirm() {
        return nameFirm;
    }

    public void setNameFirm(String nameFirm) {
        this.nameFirm = nameFirm;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Railway getRailway() {
        return railway;
    }

    public void setRailway(Railway railway) {
        this.railway = railway;
    }

    /**
     * @return the idFirm
     */
    public String getIdFirm() {
        return idFirm;
    }

    /**
     * @param idFirm the idFirm to set
     */
    public void setIdFirm(String idFirm) {
        this.idFirm = idFirm;
    }
}