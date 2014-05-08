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
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 * @author Tkachuk Evgen
 */
public class ImportRailsString extends Import {
    private RailsStrings rs;
    private Session session;
    private Transaction tx;
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
                        rs = new RailsStrings();
                        rs.setRailway(row.getCell(1).toString());
                        rs.setFirm((int)row.getCell(2).getNumericCellValue());
                        rs.setDirection(row.getCell(3).toString());
                        rs.setRunningLine(row.getCell(4).toString());
                        rs.setLineType(row.getCell(5).toString());
                        rs.setLine((int)row.getCell(6).getNumericCellValue());
                        rs.setRailThread(row.getCell(7).toString());
                        rs.setNumberOfString(row.getCell(8).toString());
                        rs.setKmS((int)row.getCell(9).getNumericCellValue());
                        rs.setmS(row.getCell(10).getNumericCellValue());
                        rs.setKmE((int)row.getCell(11).getNumericCellValue());
                        rs.setmE(row.getCell(12).getNumericCellValue());
                        rs.setStringLength((float)row.getCell(13).getNumericCellValue());
                        session.save(rs);
                    }
                }
            }
            deleteAll(RailsStrings.class);
            tx.commit();
        }catch (HibernateException e) {
            tx.rollback();
        }finally {
            session.close();
        }
    }
}
