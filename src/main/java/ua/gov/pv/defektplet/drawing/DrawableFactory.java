/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class DrawableFactory {

    
    public static Drawable createDrawable(Object obj,IntervalInformation ii, GraphicsCharacteristics gc) {
        if (obj instanceof Deviation) {
            return new DrawDeviation((Deviation) obj, gc, ii);
        }
        if (obj instanceof GovernedVelocity) {
            return new DrawGovernedVelocity((GovernedVelocity) obj, gc, ii);
        }
        if (obj instanceof RailsDefect) {
            return new DrawDefekt((RailsDefect) obj, gc, ii);
        }
        if (obj instanceof RailsStrings) {
            return new DrawRailsString( (RailsStrings) obj, gc, ii);
        }
        if (obj instanceof TemporaryRecovery) {
            return new DrawTemporaryRecovery( (TemporaryRecovery) obj, gc, ii);
        }
        return null;

    }
        
}
