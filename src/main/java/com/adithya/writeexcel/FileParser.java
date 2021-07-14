/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adithya.writeexcel;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LENOVO
 */
public class FileParser {
    private String inputFileName;
    private String outputFileName;
    private String rowSeparator;
    private String fieldSeparator;
    private Logger fileParserLog;

    public void setFileParserLog(Logger fileParserLog) {
        this.fileParserLog = fileParserLog;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
    
    public String getFileName() {
        return inputFileName;
    }

    public void setFileName(String fileName) {
        this.inputFileName = fileName;
    }

    public String getRowSeparator() {
        return rowSeparator;
    }

    public void setRowSeparator(String rowSeparator) {
        this.rowSeparator = rowSeparator;
    }

    public String getFieldSeparator() {
        return fieldSeparator;
    }

    public void setFieldSeparator(String fieldSeparator) {
        this.fieldSeparator = fieldSeparator;
    }

    public FileParser(String inputFileName, String outputFileName, String rowSeparator, String fieldSeparator) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.rowSeparator = rowSeparator;
        this.fieldSeparator = fieldSeparator;
        this.fileParserLog = Logger.getLogger(FileParser.class.getName());
    }
    
    public void ParseWriteFile () throws IOException{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        int rowCount=-1;
        try (BufferedReader br = new BufferedReader(new FileReader(this.inputFileName))) {
        String line;
        String processLine="";
        while ((line = br.readLine()) != null) {
            if(!processLine.equals("")){
                processLine = processLine +"\n"+ line;
            }
            else{
                processLine=line;
            }
            if(line.endsWith(this.rowSeparator)){
                processLine=processLine.substring(0, processLine.length()-this.rowSeparator.length());
                String[] recordDetail = new RecordDetail(this.fieldSeparator,processLine).getColumnData();
                int i;
                Row row = sheet.createRow(++rowCount);
                for(i=0;i<recordDetail.length;i++){
                    Cell cell = row.createCell(i);
                    cell.setCellValue((String) recordDetail[i]);
                }
                processLine = "";
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream(this.outputFileName)) {
            workbook.write(outputStream);
        }
    }
}
}

