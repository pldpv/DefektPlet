/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import ua.gov.pv.defektplet.entity.RailsDefect;

/**
 *
 * @author ПГМ
 */
public class RailsDefectList extends ArrayList {

    private final List<Row> list;

    public RailsDefectList(List<Row> list) {
        this.list = list;
        createRailsDefectList();
    }

    private void createRailsDefectList() {

        for (Row row : list) {
                try{
                RailsDefect rd = new RailsDefect();
                rd.setRailway(row.getCell(1).toString());
                rd.setFirm((int) row.getCell(2).getNumericCellValue());
                rd.setDirection(row.getCell(3).toString());
                rd.setRunningLine(row.getCell(4).toString());
                rd.setLineType(row.getCell(5).toString());
                rd.setLine((int) row.getCell(6).getNumericCellValue());
                rd.setKm((int) row.getCell(7).getNumericCellValue());
                rd.setM((int) row.getCell(8).getNumericCellValue());
                rd.setRailThread(row.getCell(9).toString());
                rd.setRailType(row.getCell(10).toString());
                rd.setFactory(row.getCell(11).toString());
                rd.setYearOfRoll((int) row.getCell(12).getNumericCellValue());
                rd.setFusion(row.getCell(13).toString());
                rd.setLineConstruction(row.getCell(14).toString());
                rd.setWorkingCapacity((float) row.getCell(15).getNumericCellValue());
                rd.setPassTonnage((float) row.getCell(16).getNumericCellValue());
                rd.setGovernedVelocity((int) row.getCell(17).getNumericCellValue());
                rd.setDateOfFounding(DataConversion.convertDate(row.getCell(18)));
                rd.setDefectCode(row.getCell(19).toString());
                rd.setDefectLength((float) row.getCell(20).getNumericCellValue());
                rd.setDefectHeight((float) row.getCell(21).getNumericCellValue());
                rd.setDefectWidth((float) row.getCell(22).getNumericCellValue());
                rd.setNecessaryVelocityLimit((int) row.getCell(20).getNumericCellValue());
                rd.setWaitVelocityLimit((int) row.getCell(20).getNumericCellValue());
                add(rd);
                }catch(IllegalStateException ex) {
              //  LOG.error("Помилка при імпортуванні Відомостей плітей: Лист: " + row.getSheet().getSheetName() + " Рядок:" + (row.getRowNum() + 1) + " Комірка;");
            }
                
        }
    }
}
