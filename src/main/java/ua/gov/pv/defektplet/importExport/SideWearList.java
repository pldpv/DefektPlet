/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import ua.gov.pv.defektplet.entity.SideWear;

/**
 *
 * @author 1
 */
public class SideWearList extends ArrayList {

    private final List<Row> list;
    public static final Logger LOG = Logger.getLogger(TemporaryRecoveryList.class);

    public SideWearList(List<Row> list) {
        this.list = list;
        createSideWearList();
    }

    private void createSideWearList() {

        for (Row row : list) {
            try {
                SideWear sideWear = new SideWear();
                        sideWear.setRailway(row.getCell(1).toString());
                        sideWear.setFirm((int) row.getCell(2).getNumericCellValue());
                        sideWear.setDirection(row.getCell(3).toString());
                        sideWear.setLine((int) row.getCell(4).getNumericCellValue());
                        sideWear.setRailsThread(row.getCell(5).toString());
                        sideWear.setLimb((int) row.getCell(6).getNumericCellValue());
                        sideWear.setKmS((int) row.getCell(7).getNumericCellValue());
                        sideWear.setpK((int) row.getCell(8).getNumericCellValue());
                        sideWear.setInsideSideWear((float) row.getCell(9).getNumericCellValue());
                        sideWear.setOutsideSideWear((float) row.getCell(10).getNumericCellValue());
                                add(sideWear);
            } catch (IllegalStateException ex) {
                LOG.error("Помилка при імпортуванні Відомостей плітей: Лист: " + row.getSheet().getSheetName() + " Рядок:" + (row.getRowNum() + 1) + " Комірка;");
            }
        }
    }
}
