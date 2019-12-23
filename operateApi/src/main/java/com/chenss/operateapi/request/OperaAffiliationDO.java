package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.utils.StringUtils;

import java.util.List;

public class OperaAffiliationDO extends OperaAffiliation {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getName())) {
            validateMsg.add("name");
            return false;
        }
        return true;
    }
}
