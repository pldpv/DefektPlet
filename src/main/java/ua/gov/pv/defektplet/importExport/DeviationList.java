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
                dev.setRunningLine(row.getCell(4).toString());
                dev.setLineType(row.getCell(5).toString());
                dev.setLine((int) row.getCell(6).getNumericCellValue());
                dev.setKm((int) row.getCell(7).getNumericCellValue());
                dev.setM((int) row.getCell(8).getNumericCellValue());
                dev.setRailThread(row.getCell(9).toString());
                dev.setRailType(row.getCell(10).toString());
                dev.setFactory(row.getCell(11).toString());
                dev.setYearOfRoll((int) row.getCell(12).getNumericCellValue());
                dev.setFusion(row.getCell(13).toString());
                dev.setLineConstruction(row.getCell(14).toString());
                dev.setWorkingCapacity((float) row.getCell(15).getNumericCellValue());
                dev.setPassTonnage((float) row.getCell(16).getNumericCellValue());
                dev.setGovernedVelocity((int) row.getCell(17).getNumericCellValue());
                dev.setDateOfFounding(DataConversion.convertDate(row.getCell(18)));
                dev.setDefectCode(row.getCell(19).toString());
                dev.setDefectLength((float) row.getCell(20).getNumericCellValue());
                dev.setDefectHeight((float) row.getCell(21).getNumericCellValue());
                dev.setDefectWidth((float) row.getCell(22).getNumericCellValue());
                dev.setNecessaryVelocityLimit((int) row.getCell(20).getNumericCellValue());
                dev.setWaitVelocityLimit((int) row.getCell(20).getNumericCellValue());
                add(dev);
                }catch(IllegalStateException ex) {
              //  LOG.error("Помилка при імпортуванні Відомостей плітей: Лист: " + row.getSheet().getSheetName() + " Рядок:" + (row.getRowNum() + 1) + " Комірка;");
            }
                
        }
    }
}
