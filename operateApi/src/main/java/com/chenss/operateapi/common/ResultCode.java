package com.chenss.operateapi.common;

public enum ResultCode {
    /**
     * 成功状态码
     */
    SUCCESS("1","成功"),
    /**
     * 参数错误状态码 1001-1999
     */
    PARAM_IS_INVALID("1001","参数无效"),
    PARAM_IS_BLANK("1002","参数为空或不完整"),

    /**
     * 用户错误 2001-2999
     */
    /**
     * 处理错误 3001-3999
     */
    SERVICE_ERROR("3001","处理错误")
    ;


    private String code;
    private String message;
    ResultCode(String code,String message) {
        this.code=code;
        this.message=message;
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
}
