package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaAffiliation;
import com.mysql.cj.util.StringUtils;

import java.util.List;

public class OperaAffiliationDO extends OperaAffiliation {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getName())) {
            validateMsg.add("envType");
            return false;
        }
        return true;
    }
}
