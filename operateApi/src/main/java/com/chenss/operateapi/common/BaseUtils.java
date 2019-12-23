package com.chenss.operateapi.common;

import com.chenss.utils.StringUtils;

/**
 * 基础工具类
 * @author chenss002
 */
public class BaseUtils {

    public static String getString(String source) {
        return StringUtils.isNullOrEmpty(source)? null : source;
    }
}
