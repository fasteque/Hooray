package com.fasteque.hooray.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    public static String getFormattedDateTime(String date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date));
        } catch (ParseException e) {
            return "";
        }
    }
}
