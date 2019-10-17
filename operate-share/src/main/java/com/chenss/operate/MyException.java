package com.chenss.operate;

public class MyException extends RuntimeException implements Result<String> {

    private static final long serialVersionUID = -6252174751461061499L;

    private final String code;
    private final String message;

    public MyException(MyResultCode resultCode) {
        this.code=resultCode.getCode();
        this.message=resultCode.getMessage();
    }

    public MyException(Result<?> result) {
        this.code=result.getCode();
        this.message=result.getMessage();
    }

    public MyException(String code,String message) {
        this.code=code;
        this.message=message;
    }

    public MyException(MyResultCode resultCode,Throwable cause) {
        super(cause);
        this.code=resultCode.getCode();
        this.message=resultCode.getMessage();
    }

    public MyException(String code,String message,Throwable cause) {
        super(cause);
        this.code=code;
        this.message=message;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public void setCode(String code) {

    }

    @Override
    public void setMessage(String message) {

    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public void setData(String data) {

    }
}
