package com.chenss.operateapi.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用查询控制器的请求参数，标识是否需要该结果集
 * @author chenss002
 */
@Getter
@Setter
@ToString
public class CommonQueryParam implements Serializable {
    private static final long serialVersionUID = -2182907063769278920L;
    private boolean needOperaEnv=false;
    private boolean needOperaAffiliation=false;
    private boolean needOperaOs=false;
    private boolean needOperaServiceType=false;
}
