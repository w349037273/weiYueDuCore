package com.weiyuedu.core.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述:日期操作工具类
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 08:18
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 格式化日期与时间
     */
    public static String formatDatetime(long timestamp) {
        return datetimeFormat.format(new Date(timestamp));
    }

    /**
     * 格式化日期
     */
    public static String formatDate(long timestamp) {
        return dateFormat.format(new Date(timestamp));
    }

    /**
     * 格式化时间
     */
    public static String formatTime(long timestamp) {
        return timeFormat.format(new Date(timestamp));
    }

    /**
     * 获取当前日期与时间
     */
    public static String getCurrentDatetime() {
        return datetimeFormat.format(new Date());
    }

    /**
     * 获取当前日期
     */
    public static String getCurrentDate() {
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前时间
     */
    public static String getCurrentTime() {
        return timeFormat.format(new Date());
    }

    /**
     * 解析日期与时间
     */
    public static Date parseDatetime(String str) {
        Date date = null;
        try {
            date = datetimeFormat.parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd HH:mm:ss", e);
        }
        return date;
    }

    /**
     * 解析日期
     */
    public static Date parseDate(String str) {
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd", e);
        }
        return date;
    }

    /**
     * 解析时间
     */
    public static Date parseTime(String str) {
        Date date = null;
        try {
            date = timeFormat.parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：HH:mm:ss", e);
        }
        return date;
    }

    /**
     * 增加时间
     * @param date
     * @param incTime
     * @return
     */
    public static Date addDay(Date date,Integer incTime)   {

        int timeStamp = (int) (date.getTime()/1000+incTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date(Long.valueOf(timeStamp + "000")));
        Date parse = null;
        try {
            parse = format.parse(format1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }







}
