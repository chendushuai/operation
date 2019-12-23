package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaServiceType;
import com.chenss.utils.StringUtils;

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
