/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 *
 * @author ПГМ
 */
public class TabPaneClosable extends JTabbedPane {

    public TabPaneClosable() {

    }

    public void addNewTab(JPanel panel, String title) {
        int count = 0;
        for (int i = 0; i < getTabCount(); i++) {
            if (getTitleAt(i).contains(title)) {
                count++;
            }
        }
        title = (count != 0) ? title + "(" + count + ")" : title;
        add(title, panel);
        int index = indexOfTab(title);
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        JButton btnClose = new JButton("x");
        btnClose.setBorder(BorderFactory.createEmptyBorder(1, 4, 2, 3));
        btnClose.setHorizontalAlignment(SwingConstants.CENTER);
        btnClose.setVerticalAlignment(SwingConstants.CENTER);
        btnClose.setFont(new Font("Arial", Font.BOLD, 11));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        pnlTab.add(lblTitle, gbc);
        gbc.gridx++;
        gbc.weightx = 0;
        pnlTab.add(btnClose, gbc);
        setTabComponentAt(index, pnlTab);
        btnClose.addActionListener(new MyCloseActionHandler(title));
    }

    private class MyCloseActionHandler implements ActionListener {

        private final String tabName;

        public MyCloseActionHandler(String tabName) {
            this.tabName = tabName;
        }

        public String getTabName() {
            return tabName;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            
            int index = indexOfTab(getTabName());
            if (index >= 0) {
                
                removeTabAt(index);
                setTabComponentAt(index, null);
            }
        }
    }
}
