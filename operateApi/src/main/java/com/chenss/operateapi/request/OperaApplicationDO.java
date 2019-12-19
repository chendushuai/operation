package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaApplication;
import com.chenss.operateapi.model.OperaHost;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class OperaApplicationDO extends OperaApplication {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getAppCmdbId())) {
            validateMsg.add("appCmdbId");
            return false;
        }
        if (StringUtils.isNullOrEmpty(this.getAppName())) {
            validateMsg.add("appName");
            return false;
        }
        return true;
    }
}
