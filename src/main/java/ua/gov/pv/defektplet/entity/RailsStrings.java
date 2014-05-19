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
import org.hibernate.annotations.Formula;

/**
 *
 * @author Tkacuk Evgen
 *
 */
@Entity
public class RailsStrings implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String railway;
    private Integer firm;
    private String direction;
    private String runningLine;
    private String lineType;
    private Integer line;
    private String railThread;
    private String numberOfString;
    private Integer kmS;
    private Double mS;
    private Integer kmE;
    private Double mE;
    private Float stringLength;
    @Formula("kmS*1000+mS")
    private Integer startCoordinate;
    @Formula("kmE*1000+mE")
    private Integer endCoordinate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRailway() {
        return railway;
    }

    public void setRailway(String railway) {
        this.railway = railway;
    }

    public Integer getFirm() {
        return firm;
    }

    public void setFirm(Integer firm) {
        this.firm = firm;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRunningLine() {
        return runningLine;
    }

    public void setRunningLine(String runningLine) {
        this.runningLine = runningLine;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getRailThread() {
        return railThread;
    }

    public void setRailThread(String railThread) {
        this.railThread = railThread;
    }

    public String getNumberOfString() {
        return numberOfString;
    }

    public void setNumberOfString(String numberOfString) {
        this.numberOfString = numberOfString;
    }

    public Integer getKmS() {
        return kmS;
    }

    public void setKmS(Integer kmS) {
        this.kmS = kmS;
    }

    public Double getmS() {
        return mS;
    }

    public void setmS(Double mS) {
        this.mS = mS;
    }

    public Integer getKmE() {
        return kmE;
    }

    public void setKmE(Integer kmE) {
        this.kmE = kmE;
    }

    public Double getmE() {
        return mE;
    }

    public void setmE(Double mE) {
        this.mE = mE;
    }

    public Float getStringLength() {
        return stringLength;
    }

    public void setStringLength(Float stringLength) {
        this.stringLength = stringLength;
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
