/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Tkacuk Evgen
 */
@Entity(name="TemporaryRecovery")
public class TemporaryRecovery implements Serializable {
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
    private Integer km;
    private Integer m;
    private double trLength;
    private String railThread;
    private String railType;
    private String factory;
    private Integer yearOfRoll;
    private String fusion;
    
    private Float workingCapacity;
    private Float passTonnage;
    private Integer governedVelocity;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfChange;

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

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public double getTrLength() {
        return trLength;
    }

    public void setTrLength(double trLength) {
        this.trLength = trLength;
    }

    public String getRailThread() {
        return railThread;
    }

    public void setRailThread(String railThread) {
        this.railThread = railThread;
    }

    public String getRailType() {
        return railType;
    }

    public void setRailType(String railType) {
        this.railType = railType;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Integer getYearOfRoll() {
        return yearOfRoll;
    }

    public void setYearOfRoll(Integer yearOfRoll) {
        this.yearOfRoll = yearOfRoll;
    }

    public String getFusion() {
        return fusion;
    }

    public void setFusion(String fusion) {
        this.fusion = fusion;
    }

    public Float getWorkingCapacity() {
        return workingCapacity;
    }

    public void setWorkingCapacity(Float workingCapacity) {
        this.workingCapacity = workingCapacity;
    }

    public Float getPassTonnage() {
        return passTonnage;
    }

    public void setPassTonnage(Float passTonnage) {
        this.passTonnage = passTonnage;
    }

    public Integer getGovernedVelocity() {
        return governedVelocity;
    }

    public void setGovernedVelocity(Integer governedVelocity) {
        this.governedVelocity = governedVelocity;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }
}
