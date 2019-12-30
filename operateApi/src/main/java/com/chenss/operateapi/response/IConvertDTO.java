package com.chenss.operateapi.response;

/**
 * DTO转换工具类
 * @param <S> 源对象
 * @param <T> 目标对象
 * @author chenss002
 */
public interface IConvertDTO<S,T> {
    /**
     * 从源对象转换成DTO对象
     * @param sourceObj
     * @return 转换结果
     */
    T convertTo(S sourceObj);

    /**
     * 从DTO对象转换成源对象
     * @param targetObject
     * @return 转换结果
     */
    S convertFrom(T targetObject);
}
