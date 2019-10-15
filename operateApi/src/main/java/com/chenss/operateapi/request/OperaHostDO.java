package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaHost;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class OperaHostDO extends OperaHost {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getHostName())) {
            validateMsg.add("hostName");
            return false;
        }
        if (StringUtils.isNullOrEmpty(this.getHostIp())) {
            validateMsg.add("hostIp");
            return false;
        }
        return true;
    }
}
