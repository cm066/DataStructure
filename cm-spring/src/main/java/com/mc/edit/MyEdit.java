package com.mc.edit;

import java.util.Date;

/**
 * @author cm
 * @create 2021/10/23-8:52 上午
 */
public class MyEdit {
    private Date dataValue;

//    public MyEdit(Date dataValue) {
//        this.dataValue = dataValue;
//    }

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "MyEdit{" +
                "dataValue=" + dataValue +
                '}';
    }
}
