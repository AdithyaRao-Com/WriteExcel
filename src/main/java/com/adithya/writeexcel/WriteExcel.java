package com.adithya.writeexcel;

/**
 *
 * @author LENOVO
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
 
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class WriteExcel {
 
    public static void main(String[] args) throws IOException {
        String inputFileName;
        String outputFileName;
        String recordSeparator;
        String fieldSeparator;
        Logger logger = Logger.getLogger("WriteExcelLog");
        FileHandler fh1 = new FileHandler("WriteExcelLog.log");
        SimpleFormatter formatLog = new SimpleFormatter();
        fh1.setFormatter(formatLog);
        logger.addHandler(fh1);
        inputFileName   = args[0];
        outputFileName  = args[1];
        recordSeparator = args[2];
        fieldSeparator  = args[3];
        FileParser fileparse = new FileParser(inputFileName
                                            , outputFileName
                                            , recordSeparator
                                            , fieldSeparator);
        fileparse.setFileParserLog(logger);
        fileparse.ParseWriteFile();
    } 
}
