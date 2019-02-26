package com.utils;

import com.handler.Processer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * 获取当前时间
     *
     * @return String
     */
    public static String getNow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    /**
     * 比较时间大小
     * <p>
     * 返回true 前者小于后者
     */
    public static boolean isLater(String date1, String date2) throws Exception {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date dt1 = df.parse(date1);
        Date dt2 = df.parse(date2);
        if (dt1.getTime() > dt2.getTime())
            return true;
        else return false;
    }
}
