/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.helper.IntervalInformation;



/**
 *
 * @author ���
 */
public class DrawGovernedVelocity implements Drawable{
    private final IntervalInformation ii;
    private final int scale;
    private final GovernedVelocity gv;
    private final Integer lineHeight;
    private final Graphics2D g2;
    
    
    public DrawGovernedVelocity(GovernedVelocity gv, Graphics g,IntervalInformation ii, int scale,int lineHeight) {
        this.gv=gv;
        g2=(Graphics2D)g;
        this.ii=ii;
        this.scale=scale;
        this.lineHeight=lineHeight;
    }
    public void draw() {
        Font f = new Font("Arial", Font.BOLD, lineHeight);
        FontMetrics fm = g2.getFontMetrics(f);
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,1000,lineHeight);
        g2.setColor(Color.BLACK);        
        g2.drawLine(getEndX(), 0, getEndX(), lineHeight);
        g2.setColor(getColor());
        g2.drawString(getVelocity(), getStartX()+(getEndX()+getStartX()
                -fm.stringWidth(getVelocity()))/2 , lineHeight-1);
    }
    private int getStartX() {
        if (gv.getKmS()*1000+gv.getmS()<ii.kmS*1000+ii.mS){
            return 0;
        }else{
            return ((gv.getKmS()-ii.kmS)*1000+gv.getmS()-ii.kmS)*1000/scale;
        }
    }
    private int getEndX() {
        if(gv.getKmE()*1000+gv.getmE()<ii.kmE*1000+ii.mE){
            return ((gv.getKmE()-ii.kmS)*1000+gv.getmE()-ii.mS)*1000/scale;
        }else{
            return ((ii.kmE-ii.kmS)*1000-ii.mS+ii.mE)*1000/scale;
        }
    }
    private String getVelocity(){
        String str;
        str=gv.getPassengerVelocity()+"/"+gv.getFreightVelocity();
        return str;
    }
    private Color getColor() {
        if (gv.getPassengerVelocity()>140) return Color.white;
        else if ((gv.getPassengerVelocity()<=140)
                &&(gv.getPassengerVelocity()>110)) return Color.yellow;
        else if ((gv.getPassengerVelocity()<=110)
                &&(gv.getPassengerVelocity()>90)) return Color.orange;
        else if ((gv.getPassengerVelocity()<=90)
                &&(gv.getPassengerVelocity()>80)) return Color.red;
        else if ((gv.getPassengerVelocity()<=80)
                &&(gv.getPassengerVelocity()>60)) return Color.pink;
        else if ((gv.getPassengerVelocity()<=60)
                &&(gv.getPassengerVelocity()>40)) return Color.cyan;
        else return Color.black;
    }
}
