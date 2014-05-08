/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.entity;

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
@Entity
public class RailsDefect {

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
    private String railThread;
    private String railType;
    private String factory;
    private Integer yearOfRoll;
    private String fusion;
    private String lineConstruction;
    private Float workingCapacity;
    private Float passTonnage;
    private Integer governedVelocity;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfFounding;
    private String defectCode;
    private Float defectLength;
    private Float defectHeight;
    private Float defectWidth;
    private Integer necessaryVelocityLimit;
    private Integer waitVelocityLimit;

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

    public String getLineConstruction() {
        return lineConstruction;
    }

    public void setLineConstruction(String lineConstruction) {
        this.lineConstruction = lineConstruction;
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

    public Date getDateOfFounding() {
        return dateOfFounding;
    }

    public void setDateOfFounding(Date dateOfFounding) {
        this.dateOfFounding = dateOfFounding;
    }

    public String getDefectCode() {
        return defectCode;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public Float getDefectLength() {
        return defectLength;
    }

    public void setDefectLength(Float defectLength) {
        this.defectLength = defectLength;
    }

    public Float getDefectHeight() {
        return defectHeight;
    }

    public void setDefectHeight(Float defectHeight) {
        this.defectHeight = defectHeight;
    }

    public Float getDefectWidth() {
        return defectWidth;
    }

    public void setDefectWidth(Float defectWidth) {
        this.defectWidth = defectWidth;
    }

    public Integer getNecessaryVelocityLimit() {
        return necessaryVelocityLimit;
    }

    public void setNecessaryVelocityLimit(Integer necessaryVelocityLimit) {
        this.necessaryVelocityLimit = necessaryVelocityLimit;
    }

    public Integer getWaitVelocityLimit() {
        return waitVelocityLimit;
    }

    public void setWaitVelocityLimit(Integer waitVelocityLimit) {
        this.waitVelocityLimit = waitVelocityLimit;
    }

    

}
