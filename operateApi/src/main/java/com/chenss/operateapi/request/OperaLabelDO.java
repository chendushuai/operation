package com.chenss.operateapi.request;

import com.chenss.operateapi.common.RequestParam;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.model.OperaLabel;
import com.mysql.cj.util.StringUtils;

import java.util.List;

/**
 * @author chenss002
 */
public class OperaLabelDO extends OperaLabel implements RequestParam {
    private static final long serialVersionUID = -4331671322498261815L;
    private List<String> validateMsg;
    public boolean validate() {
        if (StringUtils.isNullOrEmpty(this.getLabelGroup())) {
            validateMsg.add("labelGroup");
            return false;
        }
        if (StringUtils.isNullOrEmpty(this.getLabelKey())) {
            validateMsg.add("labelKey");
            return false;
        }
        if (StringUtils.isNullOrEmpty(this.getLabelValue())) {
            validateMsg.add("labelValue");
            return false;
        }
        return true;
    }
}
