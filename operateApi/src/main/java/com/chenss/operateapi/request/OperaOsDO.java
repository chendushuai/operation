package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.model.OperaOs;
import com.mysql.cj.util.StringUtils;

import java.util.List;

/**
 * @author chenss002
 */
public class OperaOsDO extends OperaOs {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getOsName())) {
            validateMsg.add("osName");
            return false;
        }
        if (StringUtils.isNullOrEmpty(this.getOsVersion())) {
            validateMsg.add("osVersion");
            return false;
        }
        return true;
    }
}
