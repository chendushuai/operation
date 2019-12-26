package com.chenss.operateapi.common;

import com.chenss.operate.MyResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 609255741792982634L;
    @Getter
    @Setter
    private T object;
    @Getter
    @Setter
    private String success;
    @Getter
    @Setter
    private String msg;

    public ResponseDTO(T object) {
        this.success = MyResultCode.SUCCESS.getCode();
        this.msg = MyResultCode.SUCCESS.getMessage();
        this.object = object;
    }

    public ResponseDTO(MyResultCode myResultCode) {
        this.success = myResultCode.getCode();
        this.msg = myResultCode.getMessage();
    }

    public ResponseDTO(String code, String message) {
        this.success = code;
        this.msg = message;
    }
}
