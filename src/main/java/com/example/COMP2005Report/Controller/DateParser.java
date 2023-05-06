package com.example.COMP2005Report.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    public static Date DateParsing(String datestring) {
        String format = "yyyy-MM-dd'T'HH:mm:ss";
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            date = formatter.parse(datestring);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
