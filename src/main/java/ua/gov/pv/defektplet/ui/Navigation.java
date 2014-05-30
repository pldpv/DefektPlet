/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import ua.gov.pv.defektplet.drawing.DrawRailway;
import ua.gov.pv.defektplet.ui.ImagePanel;

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

    @Override
    public Component add(Component comp) {
        return super.add(comp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(PopupMenu popup) {
        super.add(popup); //To change body of generated methods, choose Tools | Templates.
    }

}
