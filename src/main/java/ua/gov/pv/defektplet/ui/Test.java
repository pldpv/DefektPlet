/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.ui;


import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Евген
 */
public class Test extends JFrame{
     public static void main(String ... args) {
        Test t=new Test();
        t.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel panel = new Panel("dfjghk");
        panel.requestFocusInWindow();
        panel.setBounds(500, 500, 100, 100);
        panel.setLocation(200, 200);
        t.add(panel);
        t.setContentPane(panel);
        t.setVisible(true);
    }
}
