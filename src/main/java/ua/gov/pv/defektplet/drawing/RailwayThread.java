/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JCheckBox;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;
import ua.gov.pv.defektplet.util.DrawableList;
import ua.gov.pv.defektplet.util.FillDrawableList;

/**
 *
 * @author ПГМ
 */
public class RailwayThread {

    private final IntervalInformation ii;
    private final GraphicsCharacteristics gc;
    private final JCheckBox[] cb;
    private List<DrawableList> railThread = new ArrayList<DrawableList>();

    public RailwayThread(JCheckBox[] cb, IntervalInformation ii, GraphicsCharacteristics gc) {
        this.cb = cb;
        this.ii = ii;
        this.gc = gc;
    }

    private void createDrawableList() {
        FillDrawableList fillDrawable = new FillDrawableList(ii, gc);
        DefectStringsDataSource helper = new DefectStringsDataSource(ii);
        if (ii.getRailThread().equals("Права")) {

            DrawableList govVelocity = new DrawableList(createBImage(1));
            fillDrawable.fillList(govVelocity, helper.getGovernedVelocity());
            railThread.add(govVelocity);
            if (cb[2].isSelected()) {

                DrawableList realigning = new DrawableList(createBImage(1));
                fillDrawable.fillList(realigning, helper.getDeviations("Р"));
                railThread.add(realigning);
            }
            if (cb[3].isSelected()) {

                DrawableList obliqueSetting = new DrawableList(createBImage(1));
                fillDrawable.fillList(obliqueSetting, helper.getDeviations("П"));
                railThread.add(obliqueSetting);
            }
            if (cb[4].isSelected()) {

                DrawableList leftSag = new DrawableList(createBImage(1));
                fillDrawable.fillList(leftSag, helper.getDeviations("Пр.л"));
                railThread.add(leftSag);
                DrawableList rightSag = new DrawableList(createBImage(1));
                fillDrawable.fillList(rightSag, helper.getDeviations("Пр.п"));
                railThread.add(rightSag);
            }
            if (cb[5].isSelected()) {

                DrawableList widening = new DrawableList(createBImage(1));
                fillDrawable.fillList(widening, helper.getDeviations("У"));
                railThread.add(widening);
            }
            if (cb[6].isSelected()) {

                DrawableList narrowPart = new DrawableList(createBImage(1));
                fillDrawable.fillList(narrowPart, helper.getDeviations("Суж"));
                railThread.add(narrowPart);
            }

        }

        DrawableList railStrings = new DrawableList(createBImage(1));
        fillDrawable.fillList(railStrings, helper.getRailsStrings());
        DrawableList insideWear = new DrawableList(createBImage(1));
        fillDrawable.fillList(insideWear, helper.getSideWear());

        if (cb[0].isSelected()) {

            DrawableList railDefect = new DrawableList(createBImage(1));
            fillDrawable.fillList(railDefect, helper.getRailsDefectList());
            railThread.add(railDefect);
        }
        if (cb[1].isSelected()) {
            fillDrawable.fillList(railStrings, helper.getTemporaryRecovery());
        }
        if (ii.getRailThread().equals("Права")) {
            railThread.add(railStrings);
            railThread.add(insideWear);
        }else{
            railThread.add(insideWear);
            railThread.add(railStrings);
        }

    }

    private BufferedImage createBImage(Integer numberOfLines) {
        return new BufferedImage(gc.IMG_WIDTH, gc.HEIGHT * numberOfLines,
                BufferedImage.TYPE_INT_RGB);
    }

    public List<DrawableList> getRailThread() {
        createDrawableList();
        return railThread;
    }
}
