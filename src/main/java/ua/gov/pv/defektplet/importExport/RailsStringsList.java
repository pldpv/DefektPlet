/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import ua.gov.pv.defektplet.entity.RailsStrings;

public class RailsStringsList extends ArrayList {

    private final List<Row> list;
    private static final Logger logger = Logger.getLogger(RailsStringsList.class);
    public static final Logger LOG = Logger.getLogger("ua.gov.pv");

    public RailsStringsList(List<Row> list) {
        this.list = list;
        createRailsStrings();
    }

    private void createRailsStrings() throws IllegalStateException {

        for (Row row : list) {
            try {
                RailsStrings rs = new RailsStrings();
                rs.setRailway(row.getCell(1).toString());
                rs.setFirm((int) row.getCell(2).getNumericCellValue());
                rs.setDirection(row.getCell(3).toString());
                rs.setRunningLine(row.getCell(4).toString());
                rs.setLineType(row.getCell(5).toString());
                rs.setLine((int) row.getCell(6).getNumericCellValue());
                rs.setRailThread(row.getCell(7).toString());
                rs.setNumberOfString(row.getCell(8).toString());
                rs.setKmS((int) row.getCell(9).getNumericCellValue());
                rs.setmS(row.getCell(10).getNumericCellValue());
                rs.setKmE((int) row.getCell(11).getNumericCellValue());
                rs.setmE(row.getCell(12).getNumericCellValue());
                rs.setStringLength((float) row.getCell(13).getNumericCellValue());
                add(rs);
            } catch (IllegalStateException ex) {
                LOG.error("Помилка при імпортуванні Відомостей плітей: Лист: " + row.getSheet().getSheetName() + " Рядок:" + (row.getRowNum() + 1) + " Комірка;");
            }
        }
    }
}
