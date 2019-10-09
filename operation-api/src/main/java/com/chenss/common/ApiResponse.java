package com.chenss.common;

public class ApiResponse<T> {
    private boolean success=false;
    private T data;
    private String code;
    private String msg;
    private String errorParam;

    public ApiResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public String getErrorParam() {
        return errorParam;
    }

    public void setErrorParam(String errorParam) {
        this.errorParam = errorParam;
    }
}
