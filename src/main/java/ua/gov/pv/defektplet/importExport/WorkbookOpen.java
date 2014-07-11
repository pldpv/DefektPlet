/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.importExport;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author ПГМ
 */
public class WorkbookOpen {

    private final File file;
    private Workbook wb;

    public WorkbookOpen(File file) {
        this.file = file;
    }

    public Workbook getWorkbook() throws InvalidFormatException {
        try {
            wb = WorkbookFactory.create(file);
        } catch (IOException ex) {
            Logger.getLogger(WorkbookOpen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wb;
    }
}
