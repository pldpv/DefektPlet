/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import static ua.gov.pv.defektplet.ui.Someclass.labels;

/**
 *
 * @author ПГМ
 */
public class ChooseIntervalPanel extends JPanel {

    private final JLabel[] label = new JLabel[6];
    private final JTextField[] textFiels = new JTextField[5];
    private JComboBox<Integer> cbScale;
    private JComboBox [] chooseCombo=new JComboBox[4];
    final JCheckBox[] drawCheckBox = new JCheckBox[7];
    JButton bDraw;

    public ChooseIntervalPanel() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        label[0] = new JLabel(labels.getString("jlRailway"));
        label[1] = new JLabel(labels.getString("jlFirm"));
        label[2] = new JLabel(labels.getString("jlDirection"));
        label[3] = new JLabel(labels.getString("jlLine"));
        label[4] = new JLabel(labels.getString("jlKm"));
        label[5] = new JLabel(labels.getString("jlScale"));
        c.gridx = 0;
        for (JLabel l : label) {
            c.gridy = 0;
            c.weightx = 1;
            c.insets = new Insets(0, 2, 0, 5);
            c.fill = GridBagConstraints.CENTER;
            add(l, c);
            c.gridx++;
        }
        chooseCombo[0]=new JComboBox<String>();
        chooseCombo[0].addItem("Оберіть залізницю");
        chooseCombo[0].addItem("Південна");
        chooseCombo[1]=new JComboBox<String>();
        chooseCombo[1].addItem("Оберіть дистанцію колії");
        chooseCombo[1].addItem("ПЧ-10");
        chooseCombo[2]=new JComboBox<String>();
        chooseCombo[2].addItem("Оберіть напрямок");
        chooseCombo[2].addItem("Дарниця - Полтава");
        chooseCombo[3]=new JComboBox<Integer>();
        chooseCombo[3].addItem("Оберіть колію");
        chooseCombo[3].addItem(1);
        chooseCombo[3].addItem(2);
        textFiels[0] = new JTextField();
        c.gridx = 0;
        for (JComboBox combo : chooseCombo) {
            c.gridy = 1;
            c.weightx = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            add(combo, c);
            c.gridx++;
        }
        
        add(textFiels[0],c);
        cbScale = new JComboBox<Integer>();
        cbScale.addItem(1);
        cbScale.addItem(2);
        cbScale.addItem(5);
        cbScale.addItem(10);
        cbScale.setPreferredSize(textFiels[0].getPreferredSize());
        c.gridy = 1;
        c.gridx = label.length - 1;
        c.weightx = 1;
        add(cbScale, c);
        bDraw = new JButton(labels.getString("bDraw"));
        c.gridy = 0;
        c.gridx = label.length;
        c.gridheight = 2;
        c.weightx = 0.1;
        c.ipady = 10;
        c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        add(bDraw, c);

        drawCheckBox[0] = new JCheckBox(labels.getString("cbDefect"));
        drawCheckBox[1] = new JCheckBox(labels.getString("cbTempRecovery"));
        drawCheckBox[2] = new JCheckBox(labels.getString("cbR"));
        drawCheckBox[3] = new JCheckBox(labels.getString("cbP"));
        drawCheckBox[4] = new JCheckBox(labels.getString("cbPr"));
        drawCheckBox[5] = new JCheckBox(labels.getString("cbU"));
        drawCheckBox[6] = new JCheckBox(labels.getString("cbS"));
        JPanel cbP = new JPanel();
        for (JCheckBox cb : drawCheckBox) {
            cbP.add(cb, c);
        }
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        add(cbP, c);

    }

    public String getDirection() {
        return (String)chooseCombo[2].getSelectedItem();
    }

    public int getLine() {
        return (int)chooseCombo[3].getSelectedItem();
    }

    public int getKm() {
        return Integer.parseInt(textFiels[0].getText());
    }

    public int getScale() {
        return (int) cbScale.getSelectedItem();
    }

    public static void main(String... args) {
//        JFrame jf = new JFrame();
//     
//        jf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        //     jf.setSize(new Dimension(500, 500));
//  //      ChooseIntervalPanel cp = new ChooseIntervalPanel();
//        jf.add(cp);
//        jf.setVisible(true);
    }
}
