/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.helper;

/**
 *
 * @author �����
 */
public class IntervalInformation {
    private Integer kmS;
    private Integer mS;
    private Integer kmE;
    private Integer mE;
    private Integer line;
    private String direction;
    private String railThread;

    public IntervalInformation(String direction, Integer kmS, Integer mS, Integer kmE, Integer mE, Integer line,String railThread) {
        this.direction = direction;
        this.kmS = kmS;
        this.mS = mS;
        this.kmE = kmE;
        this.mE = mE;
        this.line = line;
        this.railThread=railThread;
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

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRailThread() {
        return railThread;
    }

    public void setRailThread(String railThread) {
        this.railThread = railThread;
    }

    
}
