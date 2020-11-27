package com.mn.level6shift.component.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/11/27 9:34
 * DESC
 */
public class TimeUtil {

    public static String getFormatTime(UnitOfTimeMeasurement unitOfTimeMeasurement) {
        GregorianCalendar calendar = new GregorianCalendar();
        switch (unitOfTimeMeasurement) {
            case YEAR:
                int year = calendar.get(Calendar.YEAR);
                return format(year);
            case MONTH:
                int month = calendar.get(Calendar.MONTH) + 1;
                return format(month);
            case DAY:
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                return format(day);
            case HOUR:
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                return format(hour);
            case MINUTE:
                int minute = calendar.get(Calendar.MINUTE);
                return format(minute);
            case SECOND:
                int second = calendar.get(Calendar.SECOND);
                return format(second);
            default:
                return "传参错误，时间计量单位未定义";
        }
    }

    public static String getFormatTime(TimeFormat timeFormat) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(timeFormat.getDataFormat());
        return dateFormat.format(date);
    }

    /**
     * @param timeFormat example:"yyyy-MM-dd HH:mm:ss"，可根据需要格式调整
     */
    public static String getFormatTime(String timeFormat) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(timeFormat);
        return dateFormat.format(date);
    }

    private static String format(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    /**
     * 时间计量单位
     */
    public enum UnitOfTimeMeasurement {
        YEAR,
        MONTH,
        DAY,
        HOUR,
        MINUTE,
        SECOND
    }

    /**
     * 时间格式
     */
    public enum TimeFormat {

        /**
         * 年-月
         */
        Y_M("yyyy-MM"),

        /**
         * 月-日
         */
        M_H("MM-dd"),

        /**
         * 时:分
         */
        H_M("HH:mm"),

        /**
         * 年-月-日
         */
        Y_M_D("yyyy-MM-dd"),

        /**
         * 时:分:秒
         */
        H_M_S("HH:mm:ss"),

        /**
         * 年-月-日 时:分:秒
         */
        Y_M_D_H_M_S("yyyy-MM-dd HH:mm:ss");

        private String dataFormat;

        TimeFormat(String dataFormat) {
            this.dataFormat = dataFormat;
        }

        public String getDataFormat() {
            return dataFormat;
        }
    }
}
