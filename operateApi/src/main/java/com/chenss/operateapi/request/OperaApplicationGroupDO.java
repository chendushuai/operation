package com.chenss.operateapi.request;

import com.chenss.operateapi.common.RequestParam;
import com.chenss.operateapi.model.OperaApplicationGroup;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author chenss002
 */
public class OperaApplicationGroupDO extends OperaApplicationGroup implements RequestParam {
    @Getter
    @Setter
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getAppId())) {
            validateMsg.add("appId");
            return false;
        }
        if (StringUtils.isNullOrEmpty(this.getGroupId())) {
            validateMsg.add("groupId");
            return false;
        }
        return true;
    }
}
