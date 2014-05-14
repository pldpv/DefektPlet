/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;

/**
 *
 * @author ПГМ
 */
public class TemporaryRecoveryList extends ArrayList {

    private final List<Row> list;
    public static final Logger LOG=Logger.getLogger(TemporaryRecoveryList.class);
    public TemporaryRecoveryList(List<Row> list) {
        this.list = list;
        createTemporaryRecoveryList();
    }

    private void createTemporaryRecoveryList() {
        try{
        for (Row row : list) {
            TemporaryRecovery tr = new TemporaryRecovery();
            tr.setRailway(row.getCell(1).toString());
            tr.setFirm((int) row.getCell(2).getNumericCellValue());
            tr.setDirection(row.getCell(3).toString());
            tr.setRunningLine(row.getCell(4).toString());
            tr.setLineType(row.getCell(5).toString());
            tr.setLine((int) row.getCell(6).getNumericCellValue());
            tr.setKm((int) row.getCell(7).getNumericCellValue());
            tr.setM((int) row.getCell(8).getNumericCellValue());
            tr.setTrLength(row.getCell(9).getNumericCellValue());
            tr.setRailThread(row.getCell(10).toString());
            tr.setRailType(row.getCell(11).toString());
            tr.setFactory(row.getCell(12).toString());
            tr.setYearOfRoll((int) row.getCell(13).getNumericCellValue());
            tr.setFusion(row.getCell(14).toString());
            tr.setWorkingCapacity((float) row.getCell(15).getNumericCellValue());
            tr.setPassTonnage((float) row.getCell(16).getNumericCellValue());
            tr.setGovernedVelocity((int) row.getCell(17).getNumericCellValue());
            tr.setDateOfChange(DataConversion.convertDate(row.getCell(18)));
            add(tr);
        }
        }catch(IllegalStateException e ){
            LOG.log(Level.ERROR,e);
        }
    }
}
