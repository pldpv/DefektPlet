/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JPanel;
import ua.gov.pv.defektplet.drawing.DrawRailway;

/**
 *
 * @author ПГМ
 */
public class Navigation extends JPanel {

    DrawRailway drawRailway;
    public JButton next, previous;

    public Navigation() {
        init();
    }

    private void init() {
        next = new JButton("------->");
        previous = new JButton("<-------");
        add(previous);
        add(next);
    }
}
