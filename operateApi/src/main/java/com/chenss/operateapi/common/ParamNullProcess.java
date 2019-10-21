package com.chenss.operateapi.common;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;

/**
 * 进行参数的空值处理，清空空值参数值
 *
 * @param <T> 对象类型
 * @author chenss002
 * @date 2019-10-21 18:16:46
 */
public class ParamNullProcess<T> {
    Logger logger = LoggerFactory.getLogger(ParamNullProcess.class);

    /**
     * 执行参数转换
     *
     * @param param   参数对象
     * @param enclude 排除的参数值
     * @return
     */
    public T process(T param, @Nullable String... enclude) {
        try {
            Class<?> clazz = param.getClass();
            logger.info("执行参数非空处理过程。类型：{}，参数对象：[{}]，排除参数值：{}", clazz.getName(), JSON.toJSONString(param), enclude);
            Field[] classFields = clazz.getDeclaredFields();
            for (Field fieldItem :
                    classFields) {
                fieldItem.setAccessible(true);
                Object obj = fieldItem.get(param);
                if (null != obj && StringUtils.isNullOrEmpty(obj.toString())) {
                    fieldItem.set(param, null);
                }
                if (enclude.length > 0) {
                    for (String enc :
                            enclude) {
                        if (StringUtils.isNullOrEmpty(enc)) {
                            continue;
                        }
                        if (null != obj && enc.equals(obj.toString())) {
                            fieldItem.set(param, null);
                        }
                    }
                }
            }
            logger.info("执行参数非空处理过程。返回结果：[{}]", JSON.toJSONString(param));
            return param;
        } catch (Exception ex) {
            logger.error("执行参数非空处理过程中发生异常。[{}]", ex);
            return param;
        }
    }
}
