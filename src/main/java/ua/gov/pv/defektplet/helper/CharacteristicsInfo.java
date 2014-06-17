/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.helper;

/**
 *
 * @author Евген
 */
public class CharacteristicsInfo {


    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public StringBuffer getInfo() {
        return info;
    }

    public void setInfo(StringBuffer info) {
        this.info = info;
    }
    private long x, y,width,height;

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public CharacteristicsInfo(long x, long y, long width, long height, StringBuffer info) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.info = info;
    }
    private StringBuffer info;

}
