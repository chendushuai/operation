package com.chenss.utils;

/**
 * 字符串校验工具类
 * @author chenss002
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String arg) {
        return arg !=null && !"".equals(arg);
    }
}
