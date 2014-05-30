/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class DrawableFactory {

    
    public static Drawable createDrawable(Object obj,IntervalInformation ii, GraphicsCharacteristics gc,Graphics g) {
        if (obj instanceof Deviation) {
            return new DrawDeviation((Deviation) obj, gc, g, ii);
        }
        if (obj instanceof GovernedVelocity) {
            return new DrawGovernedVelocity((GovernedVelocity) obj, gc, g, ii);
        }
        if (obj instanceof RailsDefect) {
            return new DrawDefekt((RailsDefect) obj, gc, g, ii);
        }
        if (obj instanceof RailsStrings) {
            return new DrawRailsString( (RailsStrings) obj, gc, g, ii);
        }
        if (obj instanceof TemporaryRecovery) {
            return new DrawTemporaryRecovery( (TemporaryRecovery) obj, gc, g, ii);
        }
        return null;

    }
    public static void main(String ... args){
        List<Drawable> list=new ArrayList<Drawable>();
        GraphicsCharacteristics gc = new GraphicsCharacteristics(10, 0, 10, 100);
        IntervalInformation ii = new IntervalInformation("Дарниця - Полтава", 223, 0, 230, 0, 1, "Ліва");
        for (Object obj:new DefectStringsDataSource().getRailsStrings("Дарниця - Полтава", 1,"Ліва", 223, 0, 230, 0)){
            list.add(createDrawable(obj, ii, gc, new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB).createGraphics()));
        }
    System.out.println();
    }
    
}
