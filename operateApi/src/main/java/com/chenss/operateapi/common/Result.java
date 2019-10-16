package com.chenss.operateapi.common;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private String code;
    private String message;
    private T data;
    public Result(ResultCode resultCode,T data) {
        this.code=resultCode.getCode();
        this.message= resultCode.getMessage();
        this.data=data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
