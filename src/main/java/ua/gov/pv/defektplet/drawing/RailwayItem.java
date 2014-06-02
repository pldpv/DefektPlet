/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import ua.gov.pv.defektplet.helper.IntervalInformation;
import ua.gov.pv.defektplet.util.DrawableList;

/**
 *
 * @author ПГМ
 */
public class RailwayItem {

    private final IntervalInformation ii;
    private final GraphicsCharacteristics gc;
    private final JCheckBox[] cb;
    private final List<DrawableList> railwayItem = new ArrayList<DrawableList>();

    public RailwayItem(JCheckBox[] cb, IntervalInformation ii, GraphicsCharacteristics gc) {
        this.cb = cb;
        this.ii = ii;
        this.gc = gc;
    }

    private void createRailwayItem() {
        ii.setRailThread("Права");
        railwayItem.addAll(new RailwayThread(cb, ii, gc).getRailThread());
        ii.setRailThread("Ліва");
        railwayItem.addAll(new RailwayThread(cb, ii, gc).getRailThread());
    }
    public List<DrawableList> getRailwayItem(){
        createRailwayItem();
        return railwayItem;
    }
}
