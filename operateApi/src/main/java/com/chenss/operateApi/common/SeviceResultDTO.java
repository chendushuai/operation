package com.chenss.operateApi.common;

public class SeviceResultDTO<T> {
    private boolean success = false;

    private T object;

    private String msg;

    public SeviceResultDTO() {
    }

    public SeviceResultDTO(boolean success, T object) {
        this.success = success;
        this.object = object;
    }

    public SeviceResultDTO(String msg) {
        this.success = false;
        this.msg = msg;
    }

    public SeviceResultDTO<T> ok(T obj) {
        return new SeviceResultDTO(true,obj);
    }

    public SeviceResultDTO<T> fail(String msg) {
        return new SeviceResultDTO<>(msg);
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
