package com.ballot.rigging.util;

import org.springframework.stereotype.Component;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Component
public class LocalTimeUtils {

    /**
     *
     * @return yyyy-MM-dd格式的string
     */
    public String returnLocalTime() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return formatter.format(now);

    }


    /**
     *
     * @return yyyy-MM-dd格式的Date
     */
    public Date returnLocalDate() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String formatterDate = formatter.format(now);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(formatterDate, pos);
        return strtodate;

    }

    /**
     *
     * @param flag 前flag天
     * @return 返回yyyy-MM-dd格式的String，比当前日期前flag天
     */
    public String getDateBeforeOrAfterDay(int flag){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //前flag天
        calendar.add(Calendar.DATE, flag);
        Date start = calendar.getTime();
        String beforeOrAfterDayDate= format.format(start);
        return beforeOrAfterDayDate;
    }


    /**
     *
     * @param flag 前flag年
     * @return 返回yyyy-MM-dd格式的String，比当前日期前flag年
     */
    public String getDateBeforeOrAfterYear(int flag){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //前一年
        calendar.add(Calendar.YEAR, flag);
        Date start = calendar.getTime();
        String flagYear = format.format(start);
        return flagYear;
    }

    /**
     *
     * @return 返回yyyy-MM-dd hh:mm:ss格式的String
     */
    public String returnLocalTimeDetail() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return formatter.format(now);
    }
}
