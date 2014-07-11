/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.util;

import java.util.List;
import ua.gov.pv.defektplet.drawing.DrawableFactory;
import ua.gov.pv.defektplet.drawing.GraphicsCharacteristics;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class FillDrawableList {
    private final IntervalInformation ii;
    private final GraphicsCharacteristics gc;
    public FillDrawableList(IntervalInformation ii, GraphicsCharacteristics gc){
        this.ii=ii;
        this.gc=gc;
    }
    public void fillList(DrawableList listToFill, List data){
        for(Object obj:data){
            listToFill.add(DrawableFactory.createDrawable(obj, ii, gc));
        }
    }
}
