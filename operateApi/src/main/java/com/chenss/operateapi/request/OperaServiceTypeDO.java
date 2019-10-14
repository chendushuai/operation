package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.model.OperaServiceType;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class OperaServiceTypeDO extends OperaServiceType {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getServiceType())) {
            validateMsg.add("serviceType");
            return false;
        }
        return true;
    }
}
