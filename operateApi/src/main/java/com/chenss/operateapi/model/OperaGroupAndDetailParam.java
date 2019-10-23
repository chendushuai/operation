package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.List;

/**
 * 用来进行分组及分组明细插入
 * @author chenss002
 * @date 2019-10-23 17:23:01
 */
public class OperaGroupAndDetailParam extends OperaGroup implements Serializable {
    private static final long serialVersionUID = -7095153983911520722L;
    /**
     * 主机ID集合
     */
    private List<String> hostIds;

    public List<String> getHostIds() {
        return hostIds;
    }

    public void setHostIds(List<String> hostIds) {
        this.hostIds = hostIds;
    }
}
