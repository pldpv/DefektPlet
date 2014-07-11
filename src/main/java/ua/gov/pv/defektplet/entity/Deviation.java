package ua.gov.pv.defektplet.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Formula;


@Entity
public class Deviation implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String railway;
    private String direction;
    private Integer firm;
    private Integer trackRecording;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMeasuring;
    private String measuring;
    private Integer line;
    private Integer pchu;
    private Integer pd;
    private Integer pdb;
    private Integer km;
    private Integer m;
    private String deviation;
    private Integer level;
    private Integer excursion;
    private Integer deviationLength;
    private Integer rate;
    
    @Formula("km*1000+m")
    private Integer coordinate;
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

    public Date getDateMeasuring() {
        return dateMeasuring;
    }

    public void setDateMeasuring(Date dateMeasuring) {
        this.dateMeasuring = dateMeasuring;
    }

    public String getMeasuring() {
        return measuring;
    }

    public void setMeasuring(String measuring) {
        this.measuring = measuring;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getPchu() {
        return pchu;
    }

    public void setPchu(Integer pchu) {
        this.pchu = pchu;
    }

    public Integer getPd() {
        return pd;
    }

    public void setPd(Integer pd) {
        this.pd = pd;
    }

    public Integer getPdb() {
        return pdb;
    }

    public void setPdb(Integer pdb) {
        this.pdb = pdb;
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

    public String getDeviation() {
        return deviation;
    }

    public void setDeviation(String deviation) {
        this.deviation = deviation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExcursion() {
        return excursion;
    }

    public void setExcursion(Integer excursion) {
        this.excursion = excursion;
    }

    public Integer getDeviationLength() {
        return deviationLength;
    }

    public void setDeviationLength(Integer deviationLength) {
        this.deviationLength = deviationLength;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }

    public Integer getTrackRecording() {
        return trackRecording;
    }

    public void setTrackRecording(Integer trackRecording) {
        this.trackRecording = trackRecording;
    }

   

 
}
