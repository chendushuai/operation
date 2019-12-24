package com.chenss.operateapi.common;

import com.alibaba.fastjson.JSON;
import com.chenss.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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
     * @param exclude 排除的参数值
     * @return
     */
    public T process(T param, Class clazz, @Nullable String... exclude) {
        try {
            logger.info("执行参数非空处理过程。类型：{}，参数对象：[{}]，排除参数值：{}", clazz.getName(), JSON.toJSONString(param), exclude);
            Field[] classFields = clazz.getDeclaredFields();
            for (Field fieldItem :
                    classFields) {
                if (Modifier.isFinal(fieldItem.getModifiers())) {
                    continue;
                }
                fieldItem.setAccessible(true);
                Object obj = fieldItem.get(param);
                if (obj == null) {
                    continue;
                }
                if (null != obj && StringUtils.isNullOrEmpty(obj.toString())) {
                    fieldItem.set(param, null);
                    continue;
                }
                if (exclude.length > 0) {
                    for (String enc :
                            exclude) {
                        if (StringUtils.isNull(enc)) {
                            continue;
                        }
                        if (null != obj && enc.equals(obj.toString())) {
                            fieldItem.set(param, null);
                        }
                    }
                }
            }
            Class superClass = clazz.getSuperclass();
            if (superClass.getName() != "java.lang.Object") {
                process(param, superClass, exclude);
            }
            logger.info("执行参数非空处理过程。返回结果：[{}]", JSON.toJSONString(param));
            return param;
        } catch (Exception ex) {
            logger.error("执行参数非空处理过程中发生异常。[{}]", ex);
            return param;
        }
    }
}
