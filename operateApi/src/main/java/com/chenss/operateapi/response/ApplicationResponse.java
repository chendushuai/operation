package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaApplication;
import com.chenss.operateapi.model.OperaGroupHostDo;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析返回应用信息
 * @author chenss002
 * @date 2019-11-20 16:50:57
 */
public class ApplicationResponse extends OperaApplication implements Serializable {
    private static final long serialVersionUID = 4211225427377317221L;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String createTimeStr;
    private String modifyTimeStr;

    public ApplicationResponse(OperaApplication operaApplication) {
        BeanUtils.copyProperties(operaApplication,this);
    }

    public String getCreateTimeStr() {
        if (null == getCreateTime()) {
            return "";
        }

        return simpleDateFormat.format(getCreateTime());
    }

    public String getModifyTimeStr() {
        if (null == getModifyTime()) {
            return "";
        }

        return simpleDateFormat.format(getModifyTime());
    }
}
