/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.importExport;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import ua.gov.pv.defektplet.entity.Deviation;


/**
 *
 * @author ПГМ
 */
public class DeviationList extends ArrayList{
    private final List<Row> list;

    public DeviationList(List<Row> list) {
        this.list = list;
        createDeviationList();
    }

    private void createDeviationList() {

        for (Row row : list) {
                try{
                Deviation dev = new Deviation();
                dev.setRailway(row.getCell(1).toString());
                dev.setFirm((int) row.getCell(2).getNumericCellValue());
                dev.setDirection(row.getCell(3).toString());
                 add(dev);
                }catch(IllegalStateException ex) {
              //  LOG.error("Помилка при імпортуванні Відомостей плітей: Лист: " + row.getSheet().getSheetName() + " Рядок:" + (row.getRowNum() + 1) + " Комірка;");
            }
                
        }
    }
}
