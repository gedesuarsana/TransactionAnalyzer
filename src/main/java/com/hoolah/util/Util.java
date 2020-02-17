package com.hoolah.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public static Timestamp convertStringToTimestamp(String timeString) throws ParseException {
        Timestamp output = null;
        Date date = df.parse(timeString);
        output = new Timestamp(date.getTime());
        return output;
    }
}
