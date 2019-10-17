package com.chenss.operateapi.common;

import com.chenss.operate.MyResultCode;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {
    private boolean success = false;
    private T object;
    private MyResultCode error;
    private String msg;

    public ResponseDTO(T object) {
        this.success = true;
        this.object = object;
    }

    public ResponseDTO(MyResultCode error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public MyResultCode getError() {
        return error;
    }

    public void setError(MyResultCode error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
