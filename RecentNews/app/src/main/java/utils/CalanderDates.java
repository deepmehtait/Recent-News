package utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by deepmetha on 9/24/17.
 */

public class CalanderDates {
    public static String getYearMonthDateString() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String days = day <=9 ? "0"+day : ""+day;
        return month <= 9 ? ""+year+"0"+month+""+days : ""+year+""+month+""+days;
    }
}
