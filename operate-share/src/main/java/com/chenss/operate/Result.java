package com.chenss.operate;

import java.io.Serializable;

/**
 * 返回结果接口
 * @param <T> 返回结果数据类型
 * @author chenss002
 * @date 2019-10-16 18:31:15
 */
public interface Result<T> extends Serializable {
    String getCode();
    void setCode(String code);
    String getMessage();
    void setMessage(String message);
    T getData();
    void setData(T data);

    default String toJson() {
        return JsonUtils.objectToJson(this);
    }
}
