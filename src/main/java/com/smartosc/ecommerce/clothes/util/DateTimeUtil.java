package com.smartosc.ecommerce.clothes.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {

    public static final String DATE = "yyyy/MM/d";

    public static String stringOfToDay() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern(DATE);
        ZonedDateTime zonedNow = ZonedDateTime.now();
        return zonedNow.format(formatters);
    }

    public static boolean compareDate(Long date) {
        return date > new Date().getTime();
    }
}
