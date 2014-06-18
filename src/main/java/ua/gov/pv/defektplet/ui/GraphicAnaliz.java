/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.JPanel;
import ua.gov.pv.defektplet.drawing.DrawRailway;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class GraphicAnaliz extends JPanel {

    private DrawRailway drawRailway;
    private ListIterator iterator;
    ImagePanel ip;

    public GraphicAnaliz() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridy = 0;
        c.weighty = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        final ChooseIntervalPanel choosePanel = new ChooseIntervalPanel();
        add(choosePanel, c);

        final Navigation nav = new Navigation();
        nav.setVisible(false);
        c.weightx = 0;
        c.gridy = 2;
        c.weighty = 0;
        add(nav, c);

        choosePanel.bDraw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawRailway = new DrawRailway(new IntervalInformation(
                        choosePanel.getDirection(), choosePanel.getKm(), 0,
                        choosePanel.getKm() + choosePanel.getScale() * 1000 / 1000,
                        choosePanel.getScale() % 1000, choosePanel.getLine(), null),
                        choosePanel.getScale() * 1000, choosePanel.drawCheckBox);
                drawRailway.cacheRItem();
                iterator = drawRailway.iterator();
                if (ip != null) {
                    remove(ip);
                    ip = new ImagePanel(drawRailway.getGraphicsContent());
                    ip.reDraw();
                }
                ip = new ImagePanel(drawRailway.getGraphicsContent());
                ip.paint();
                ip.setVisible(true);
                c.weightx = 0.0;
                c.ipady = drawRailway.getImage().getHeight();
                c.fill = GridBagConstraints.HORIZONTAL&GridBagConstraints.VERTICAL;
                c.gridy = 1;
                c.weighty = 1;
                add(ip, c);
                nav.setVisible(true);
                revalidate();
                repaint();
            }

        });
        nav.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (iterator.hasNext()) {
                    iterator.next();
                    ip.setGraphicsContent(drawRailway.getGraphicsContent());
                    ip.reDraw();
                    revalidate();
                    repaint();
                    nav.previous.setEnabled(true);
                }
                if (!iterator.hasNext()) {
                    nav.next.setEnabled(false);
                }
            }
        });
        nav.previous.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    ip.setGraphicsContent(drawRailway.getGraphicsContent());
                    ip.reDraw();
                    revalidate();
                    repaint();
                    nav.next.setEnabled(true);
                }
                if (!iterator.hasPrevious()) {
                    nav.previous.setEnabled(false);
                }

            }
        });
    }

}
