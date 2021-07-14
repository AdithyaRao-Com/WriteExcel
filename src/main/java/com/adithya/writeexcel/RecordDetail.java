/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adithya.writeexcel;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class RecordDetail {
    private String fieldSeparator;
    private String concatenatedData;
    private Logger recordDetailLog;

    public RecordDetail(String fieldDelimiter, String concatenatedData) {
        this.fieldSeparator = fieldDelimiter;
        this.concatenatedData = concatenatedData;
        this.recordDetailLog = Logger.getLogger(RecordDetail.class.getName());
    }

    public String getFieldSeparator() {
        return fieldSeparator;
    }

    public void setFieldSeparator(String fieldSeparator) {
        this.fieldSeparator = fieldSeparator;
    }

    public void setRecordDetailLog(Logger recordDetailLog) {
        this.recordDetailLog = recordDetailLog;
    }

    public String getFieldDelimiter() {
        return fieldSeparator;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldSeparator = fieldDelimiter;
    }

    public String getConcatenatedData() {
        return concatenatedData;
    }

    public void setConcatenatedData(String concatenatedData) {
        this.concatenatedData = concatenatedData;
    }
    
    public String[] getColumnData(){
        String[] string1 = this.concatenatedData.split(this.fieldSeparator);
        return string1;
    }
}

