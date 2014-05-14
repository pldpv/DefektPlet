/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tkachuk Evgen
 */
public class Import {

    private final File file;

    public Import(File file) {
        this.file = file;
    }

    public void importDB(DefektPletDAO dao) throws InvalidFormatException {
        Session session = null;
        Transaction tx = null;
        List importList = getListForImport();
        if (importList != null) {
            try {
                session = dao.getSession();
                tx = session.beginTransaction();
                dao.deleteAll(importList.get(0).getClass());
                dao.saveList(importList);
                tx.commit();
            } catch (HibernateException ex) {
                if (tx != null) {
                    tx.rollback();
                }
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

    }

    private List getListForImport() throws InvalidFormatException {
        List list = null;
        RowList rowList = new RowList(new WorkbookOpen(file).getWorkbook());
        switch (FilenameUtils.removeExtension(file.getName()).toLowerCase()) {
            case "відомість п":
                list = new RailsStringsList(rowList);
                break;
            case "відомість тв":
                list = new TemporaryRecoveryList(rowList);
                break;
            case "відомість д":
                list = new RailsDefectList(rowList);
                break;
        }
        return list;
    }

}
