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
public class DrawableInfo {

    public void setInfo(String info) {
        this.info = info;
    }

    public int getX() {
        return x;
    }

    public DrawableInfo setX(int x) {
        return new DrawableInfo(x, this.y, this.width, this.height, this.info);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public DrawableInfo(int x, int y, int width, int height, String info) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.info = info;
    }
    private final int x;
    private int y, width, height;

    private String info;

    public String getInfo() {
        return info;
    }

}
