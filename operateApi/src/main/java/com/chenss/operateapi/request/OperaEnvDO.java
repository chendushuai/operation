package com.chenss.operateapi.request;

import com.chenss.operateapi.model.OperaEnv;
import com.mysql.cj.util.StringUtils;

import java.util.List;

/**
 * @author chenss002
 */
public class OperaEnvDO extends OperaEnv {
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getEnvType())) {
            validateMsg.add("envType");
            return false;
        }
        return true;
    }
}
