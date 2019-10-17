package com.chenss.operate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.util.StringUtils;

public class MyResult<T> implements Result<T> {

    private static final long serialVersionUID = 3795529161833691600L;
    private String code;
    private String message;
    private T data;

    public MyResult() {
    }

    public MyResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public MyResult(MyResultCode myResultCode) {
        this.code = myResultCode.getCode();
        this.message = myResultCode.getMessage();
    }

    public MyResult(T data) {
        this.code = MyResultCode.SUCCESS.getCode();
        this.message = MyResultCode.SUCCESS.getMessage();
        this.data = data;
    }

    public MyResult(MyException myException, String additionalMessage) {
        this.code=myException.getCode();
        this.message= StringUtils.isNullOrEmpty(additionalMessage)?myException.getMessage():myException.getMessage().concat(",").concat(additionalMessage);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return MyResultCode.SUCCESS.getCode().equals(this.code);
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public void setCode(String code) {

    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void setMessage(String message) {

    }

    @Override
    public T getData() {
        return null;
    }

    @Override
    public void setData(T data) {

    }
}
