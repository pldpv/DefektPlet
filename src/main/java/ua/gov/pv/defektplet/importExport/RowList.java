/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author ПГМ
 */
public class RowList extends ArrayList {

    private Sheet sheet;
    private final String sheetName;
    private final Workbook wb;

    public RowList(Workbook wb, String sheetName) {
        this.wb = wb;
        this.sheetName = sheetName;
        createRowList();
    }

    public RowList(Workbook wb) {
        this.wb = wb;
        this.sheetName = "ПЧ";
        createRowList();
    }

    private void createRowList() {
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            if (sheetNameCompare(wb.getSheetName(i))) {
                sheet = wb.getSheetAt(i);
                for (int r = 3; r <= sheet.getLastRowNum(); r++) {
                    add(sheet.getRow(r));
                }
            }
        }
    }

    private boolean sheetNameCompare(String sheetName) {
        if (this.sheetName.equals("ПЧ")) {
            return sheetName.substring(0, 2).equals(this.sheetName);
        } else {
            return sheetName.equals(this.sheetName);
        }
    }
}
