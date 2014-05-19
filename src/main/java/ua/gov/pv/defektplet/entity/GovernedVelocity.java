package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Formula;

public class GovernedVelocity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String railway;
    private String direction;
    private Integer firm;
    private Integer line;
    private Integer kmS;
    private Integer mS;
    private Integer kmE;
    private Integer mE;
    private Integer passengerVelocity;
    private Integer freightVelocity;
    private Integer uptownVelocity;
    private String cause;
    @Formula("kmS*1000+mS")
    private Integer startCoordinate;
    @Formula("kmE*1000+mE")
    private Integer endCoordinate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRailway() {
        return railway;
    }

    public void setRailway(String railway) {
        this.railway = railway;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getFirm() {
        return firm;
    }

    public void setFirm(Integer firm) {
        this.firm = firm;
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

    public Integer getPassengerVelocity() {
        return passengerVelocity;
    }

    public void setPassengerVelocity(Integer passengerVelocity) {
        this.passengerVelocity = passengerVelocity;
    }

    public Integer getFreightVelocity() {
        return freightVelocity;
    }

    public void setFreightVelocity(Integer freightVelocity) {
        this.freightVelocity = freightVelocity;
    }

    public Integer getUptownVelocity() {
        return uptownVelocity;
    }

    public void setUptownVelocity(Integer uptownVelocity) {
        this.uptownVelocity = uptownVelocity;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getStartCoordinate() {
        return startCoordinate;
    }

    public void setStartCoordinate(Integer startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    public Integer getEndCoordinate() {
        return endCoordinate;
    }

    public void setEndCoordinate(Integer endCoordinate) {
        this.endCoordinate = endCoordinate;
    }
   

}
