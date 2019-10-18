package com.chenss.operateapi.request;

import java.io.Serializable;

/**
 * 通用查询控制器的请求参数，标识是否需要该结果集
 * @author chenss002
 */
public class CommonQueryParam implements Serializable {
    private static final long serialVersionUID = -2182907063769278920L;
    private boolean needOperaEnv=false;
    private boolean needOperaAffiliation=false;
    private boolean needOperaOs=false;
    private boolean needOperaServiceType=false;

    public boolean isNeedOperaEnv() {
        return needOperaEnv;
    }

    public void setNeedOperaEnv(boolean needOperaEnv) {
        this.needOperaEnv = needOperaEnv;
    }

    public boolean isNeedOperaAffiliation() {
        return needOperaAffiliation;
    }

    public void setNeedOperaAffiliation(boolean needOperaAffiliation) {
        this.needOperaAffiliation = needOperaAffiliation;
    }

    public boolean isNeedOperaOs() {
        return needOperaOs;
    }

    public void setNeedOperaOs(boolean needOperaOs) {
        this.needOperaOs = needOperaOs;
    }

    public boolean isNeedOperaServiceType() {
        return needOperaServiceType;
    }

    public void setNeedOperaServiceType(boolean needOperaServiceType) {
        this.needOperaServiceType = needOperaServiceType;
    }

    @Override
    public String toString() {
        return "CommonQueryParam{" +
                "needOperaEnv=" + needOperaEnv +
                ", needOperaAffiliation=" + needOperaAffiliation +
                ", needOperaOs=" + needOperaOs +
                ", needOperaServiceType=" + needOperaServiceType +
                '}';
    }
}
