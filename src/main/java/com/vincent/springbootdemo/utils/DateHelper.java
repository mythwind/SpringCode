package com.vincent.springbootdemo.utils;

import java.sql.Timestamp;

/**
 * @Auther: mythwind
 * @Date: 2019/02/21 20:24
 * @Description:
 */
public class DateHelper {
    public static final Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
