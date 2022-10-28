package edu.hhu.xulifeng.microvideo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: cupxu
 * @create: 2022-10-24 15:20
 **/
public class StringToDate {
    public static Date stringToDate(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            return new Date();
        }
    }
    public static Date stringToDateTime(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            return new Date();
        }
    }
}