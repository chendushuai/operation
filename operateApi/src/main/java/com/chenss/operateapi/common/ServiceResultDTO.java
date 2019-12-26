package com.chenss.operateapi.common;

import com.chenss.operate.MyResultCode;

import java.io.Serializable;

/**
 * 服务调用返回结果封装
 *
 * @param <T>
 * @author chenss002
 * @date 2019-10-22 11:36:29
 */
public class ServiceResultDTO<T> implements Serializable {
    private boolean success = false;

    private T object;

    private String code;

    private String msg;

    public ServiceResultDTO() {
    }

    public ServiceResultDTO(boolean success, T object) {
        this.success = success;
        this.object = object;
    }

    public ServiceResultDTO(String msg) {
        this.success = false;
        this.msg = msg;
    }

    public ServiceResultDTO(T object) {
        this.code = MyResultCode.SUCCESS.getCode();
        this.msg = MyResultCode.SUCCESS.getMessage();
        this.object = object;
        this.success = true;
    }
    public ServiceResultDTO(MyResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }
    public ServiceResultDTO(String code,String msg) {
        this.code=code;
        this.msg=msg;
    }

    public ServiceResultDTO<T> ok(T obj) {
        return new ServiceResultDTO(obj);
    }

    public ServiceResultDTO<T> fail(String msg) {
        return new ServiceResultDTO<>(msg);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
