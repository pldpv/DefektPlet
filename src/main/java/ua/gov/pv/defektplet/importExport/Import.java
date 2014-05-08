/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.gov.pv.defektplet.util.HibernateUtil;

/**
 *
 * @author Tkachuk Evgen
 */
public abstract class Import {

    protected POIFSFileSystem fs;
    protected HSSFWorkbook wb;
    protected HSSFSheet sheet;
    protected HSSFRow row;
    protected HSSFCell cell;
    
    
    /**
     * Imports information from Excel file into DB
     * @param file Excel file which must be import
     */
    public void importDB(File file) {
        try {
            fs = new POIFSFileSystem(new FileInputStream(file));
            wb = new HSSFWorkbook(fs);
        } catch (IOException ex) {
            System.err.println(ex);
            //Logger logger = Logger.getLogger(TemporaryRecovery.class);
        }
    }
    /**
     * Deletes all information from DataBase table 
     * @param clazz Entity class mapped to the DataBase table
     */
    protected void deleteAll(Class clazz) {
        Session session;
        Transaction tx;
        List list = new LinkedList();
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        list = session.createCriteria(clazz).list();
        for (Object obj : list) {
            session.delete(obj);
        }
        tx.commit();
        session.close();
    }
    
    
    /**
     * Converts Excel Cell into Date Type depends of input Type
     * @param cell the cell to be converting into Date
     * @return the Date  
     */
    protected Date convertDate(HSSFCell cell) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = (cell.getCellType() == CELL_TYPE_STRING) ? formatter.parse(cell.toString()) : cell.getDateCellValue();
        } catch (ParseException ex) {
            Logger.getLogger(ImportTemporary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
