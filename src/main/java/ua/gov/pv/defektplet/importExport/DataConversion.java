/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

/**
 *
 * @author Tkachuk Evgen
 */
public class DataConversion {

    /**
     * Converts Excel Cell into Date Type depends of input Type
     * @param cell the cell to be converting into Date
     * @return the Date
     */
    public static Date convertDate(Cell cell) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = (cell.getCellType() == CELL_TYPE_STRING) ? formatter.parse(cell.toString()) : cell.getDateCellValue();
        } catch (ParseException ex) {
            System.err.println(ex);
        }
        return date;
    }
}
