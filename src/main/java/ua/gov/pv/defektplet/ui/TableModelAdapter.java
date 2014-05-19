/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Евген
 */
public class TableModelAdapter extends AbstractTableModel {

    private List<Object[]> list;

    public TableModelAdapter(List<Object[]> aList) {
        list = aList;
    }

    public int getColumnCount() {
        if (list == null) {
            return 0;
        }
        if (list.size() == 0) {
            return 0;
        }
        return list.get(0).length;
    }

    public int getRowCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getValueAt(int row, int column) {
        if (list == null) {
            return null;
        }
        return list.get(row)[column];
    }
}
