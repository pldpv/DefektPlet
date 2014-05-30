/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static ua.gov.pv.defektplet.ui.Someclass.labels;

/**
 *
 * @author ПГМ
 */
public class DefectMenuBar extends JMenuBar {

    private final JFrame frame;

    //Creating Menu
    public DefectMenuBar(JFrame frame) {
        this.frame = frame;
        init();

    }

    private void init() {

        JMenu fileMenu = new JMenu(labels.getString("fileMenu"));

        JMenuItem importDbMItem = new JMenuItem(labels.getString("importDB"));
        JMenuItem saveAsMItem = new JMenuItem(labels.getString("saveAs"));
        JMenuItem exitMItem = new JMenuItem(labels.getString("exit"));
        fileMenu.add(importDbMItem);
        fileMenu.add(saveAsMItem);
        fileMenu.add(exitMItem);

        JMenu settingsMenu = new JMenu(labels.getString("settingsMenu"));
        JMenuItem appSettingsMItem = new JMenuItem(labels.getString("appSettings"));
        JMenuItem dbSettingsMItem = new JMenuItem(labels.getString("dbSettings"));
        settingsMenu.add(appSettingsMItem);
        settingsMenu.add(dbSettingsMItem);

        JMenu helpMenu = new JMenu(labels.getString("helpMenu"));
        JMenuItem helpMItem = new JMenuItem(labels.getString("help"));
        JMenuItem aboutMItem = new JMenuItem(labels.getString("about"));
        helpMenu.add(helpMItem);
        helpMenu.add(aboutMItem);

        add(fileMenu);
        add(settingsMenu);
        add(helpMenu);

        exitMItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame.isDisplayable()) {
                    frame.dispose();
                }
            }
        });
    }

    
}
