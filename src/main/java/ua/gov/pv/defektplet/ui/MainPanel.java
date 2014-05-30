package ua.gov.pv.defektplet.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import static ua.gov.pv.defektplet.ui.Someclass.labels;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ПГМ
 */
public class MainPanel extends JPanel {

    public JButton jbImport;
    public JButton jbDrawRailway;
    private TabPaneClosable tabPane;
    MainPanel(TabPaneClosable tabPane) {
        this.tabPane = tabPane;
        initComponents();
    }

    private void initComponents() {
        
        Dimension d = new Dimension(400, 200);
        JPanel jPanel = new JPanel(new GridLayout());
        jPanel.setPreferredSize(d);

        jbImport = new JButton(labels.getString("importDB"));
        jbDrawRailway = new JButton(labels.getString("drawRailway"));

        jbImport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabPane.addNewTab(new GraphicAnaliz(), labels.getString("importDB"));
            }
        });
        jbDrawRailway.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabPane.addNewTab(new GraphicAnaliz(), labels.getString("drawRailway"));
            }
        });

        jPanel.add(jbImport);
        jPanel.add(jbDrawRailway);
        add(jPanel, BorderLayout.WEST);

    }

    public MainPanel() {
        initComponents();
    }
    public JPanel setPanelMaxWidth(JPanel p){
        Dimension d= p.getMaximumSize();
        p.setSize(d.width, d.height);
        return p;
    }
}
