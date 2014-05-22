/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import ua.gov.pv.defektplet.util.DrawableList;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class DrawSomeThing {

    IntervalInformation ii;
    List<DrawableList<? extends Drawable>> list;

    public DrawSomeThing(IntervalInformation ii, List<DrawableList<? extends Drawable>> list) {
        this.ii = ii;
        this.list = list;
    }

    public static void main(String... args) {
        Integer kmS = 137;
        Integer scale = 1000;
        Integer IMG_WIDTH = 1000;
        int line = 1;
        List<DrawableList<? extends Drawable>> list = new ArrayList<DrawableList<? extends Drawable>>();
        list.add(new DrawableList<DrawDefekt>());
        list.add(new DrawableList<DrawRailsString>());
        IntervalInformation ii1 = new IntervalInformation("Дарниця - Полтава",
                kmS, 0, kmS + scale / 1000, scale % 1000, line, "Ліва");
        IntervalInformation ii2 = new IntervalInformation("Дарниця - Полтава",
                kmS, 0, kmS + scale / 1000, scale % 1000, line, "Права");
        List<RailwayItem> rItemList = new ArrayList<RailwayItem>();
        DrawSomeThing ds = new DrawSomeThing(ii1, list);
        GraphicsCharacteristics gcRItem
                = new GraphicsCharacteristics(IMG_WIDTH / 10, 0, 10, scale / 10);
        RailwayItem ri = new RailwayItem(gcRItem, ii1, list, new DefectStringsDataSource());
     
    }


}
