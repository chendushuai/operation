package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaGroupHostDo;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析返回分组主机信息
 * @author chenss002
 * @date 2019-10-23 10:37:02
 */
public class GroupHostResponse extends OperaGroupHostDo implements Serializable {
    private static final long serialVersionUID = 4211225427377317221L;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String createTimeStr;
    private String modifyTimeStr;
    private List<EnvHostDO> childHosts;

    public GroupHostResponse(OperaGroupHostDo groupHostDo) {
        BeanUtils.copyProperties(groupHostDo,this);
        createHostInfoList();
    }

    public void createHostInfoList() {
        childHosts = new ArrayList<>();
        if (StringUtils.isNullOrEmpty(getHostInfo())) {
        }
        String[] envHostArr = getHostInfo().split(",");
        childHosts = new ArrayList<>();
        for (int i = 0; i < envHostArr.length; i++) {
            if (StringUtils.isNullOrEmpty(envHostArr[i])) {
                continue;
            }
            String[] envAndHost = envHostArr[i].split("\\|");
            EnvHostDO envHostDO = new EnvHostDO();
            if (envAndHost.length!=4) {
                continue;
            }
            envHostDO.setEnvType(envAndHost[0]);
            envHostDO.setEnvName(envAndHost[1]);
            envHostDO.setHostName(envAndHost[2]);
            envHostDO.setHostIp(envAndHost[3]);
            childHosts.add(envHostDO);
        }
    }

    public List<EnvHostDO> getChildHosts() {
        return childHosts;
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
