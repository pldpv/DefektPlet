/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 *
 * @author Tkachuk Evgen
 *
 *
 */
public class ImportTemporary extends Import {
   
    private Session session;
    private Transaction tx;
    private TemporaryRecovery tr;
    
    /**
     * Override method which call super method then parsing Excel file.
     * If there are no Exception during parsing it delete all information
     * from the DB table and insert parsing data
     * @param file 
     */
    @Override
    public void importDB(File file) {
        super.importDB(file);
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                if (wb.getSheetName(i).substring(0, 2).equals("ПЧ")) {
                    sheet = wb.getSheetAt(i);
                    for (int r = 3; r <= sheet.getLastRowNum(); r++) {
                        row = sheet.getRow(r);
                        tr = new TemporaryRecovery();
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
                        tr.setDateOfChange(convertDate(row.getCell(18)));
                        session.save(tr);
                    }
                }
            }
            deleteAll(TemporaryRecovery.class);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            session.close();
        }
    }
}
