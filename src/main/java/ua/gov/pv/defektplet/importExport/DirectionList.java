/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import ua.gov.pv.defektplet.entity.Direction;

/**
 *
 * @author ПГМ
 */
public class DirectionList extends ArrayList {

    private final List<Row> list;

    public DirectionList(List<Row> list) {
        this.list = list;
        createDirectionList();
    }

    private void createDirectionList() {

        for (Row row : list) {
            try {
                Direction d = new Direction();
              //  d.setIdDirection((int)row.getCell(1).getNumericCellValue());
              //  d.setNameDirection((row.getCell(2).toString()));
                d.setLine((int) row.getCell(3).getNumericCellValue());
                d.setKmS((int) row.getCell(4).getNumericCellValue());
                d.setmS((int) row.getCell(5).getNumericCellValue());
                d.setKmE((int) row.getCell(6).getNumericCellValue());
                d.setmE((int) row.getCell(7).getNumericCellValue());
                add(d);
            } catch (IllegalStateException ex) {
                //  LOG.error("Помилка при імпортуванні Відомостей плітей: Лист: " + row.getSheet().getSheetName() + " Рядок:" + (row.getRowNum() + 1) + " Комірка;");
            }
        }
    }
}
