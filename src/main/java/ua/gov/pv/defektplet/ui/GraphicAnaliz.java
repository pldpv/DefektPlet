/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private ImagePanel ip;
    private Legend legend;

    public GraphicAnaliz() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridy = 0;
        c.weighty = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        final ChooseIntervalPanel choosePanel = new ChooseIntervalPanel();
        add(choosePanel, c);
        final Navigation nav = new Navigation();

        choosePanel.bDraw.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (choosePanel.getKm() >= 121 && choosePanel.getKm() <= 130) {
                    drawRailway = new DrawRailway(new IntervalInformation(
                            choosePanel.getDirection(), choosePanel.getKm(), 0,
                            choosePanel.getKm() + choosePanel.getScale() * 1000 / 1000,
                            choosePanel.getScale() % 1000, choosePanel.getLine(), null),
                            choosePanel.getScale() * 1000, choosePanel.drawCheckBox);
                    drawRailway.cacheRItem();
                    iterator = drawRailway.iterator();
                    List<String> legendList = choosePanel.createLegend();
                    if (ip != null) {
                        remove(ip);
                        ip = new ImagePanel(drawRailway.getGraphicsContent());
                        ip.reDraw();
                    }
                    if (legend != null) {
                        remove(legend);
                        legend = new Legend(legendList, ip.getImage().getHeight() / legendList.size());
                    }
                    ip = new ImagePanel(drawRailway.getGraphicsContent());


                    //Legend
                    c.gridwidth = 1;
                //    c.ipady = ip.getImage().getHeight();
                    c.gridy = 1;
                    c.fill = GridBagConstraints.HORIZONTAL&GridBagConstraints.VERTICAL;
                    c.weightx=0.5;
                    c.weighty=1;
                    c.gridx = 0;
                    legend = new Legend(legendList, ip.getImage().getHeight() / legendList.size());
                    add(legend, c);


                    //Adding ImagePanel

                    ip.paint();

                    ip.setVisible(true);

                 //   c.anchor=GridBagConstraints.LAST_LINE_END;
                    c.fill = GridBagConstraints.HORIZONTAL & GridBagConstraints.VERTICAL;
                    c.weightx = 0.5;
                    c.gridy = 1;
                    c.gridx = 1;
                    c.weighty = 1;

                    add(ip, c);

                    //Adding Navigation
                    c.insets = new Insets(0, 0, 0, 0);
                    c.weightx = 0;
                    c.gridy =2;
                    c.gridheight = 1;
                    c.gridwidth = 2;
                    c.weighty = 0;
                    add(nav, c);

                    revalidate();
                    repaint();

                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Перегін знаходиться в межах 121-130км! Введіть кілометр в межах перегону!", "Помилка", JOptionPane.ERROR_MESSAGE);
                }
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
