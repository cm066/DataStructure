package com.mc.env;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cm
 * @create 2021/10/23-8:53 上午
 */
public class DataEdit extends PropertyEditorSupport {
    private String fomat = "yyyy-DD-dd";
    public void setFomat(String fomat){
        this.fomat = fomat;
    }

    @Override
    public void setAsText(String arg0) throws IllegalArgumentException {
        System.out.println("arg0:"+arg0);
        SimpleDateFormat sdf =new SimpleDateFormat(fomat);
        try {
            Date d= sdf.parse(arg0);
            this.setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
//    public void setAsText(String arg0){
//
//    }
}
