package com.chenss.operateapi.param;

import java.io.Serializable;

/**
 * 查询分组和主机明细信息查询条件
 * @author chenss002
 * @date 2019-10-23 10:51:51
 */
public class GroupHostParam extends PagerParam implements Serializable {
    /**
     * 分组ID
     */
    private String id;

    /**
     * 分组类型（主机分组、域名分组）
     */
    private String groupType;

    /**
     * 分组名称
     */
    private String groupName;
    private Integer envId;
    private String hostName;
    private String hostIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getEnvId() {
        return envId;
    }

    public void setEnvId(Integer envId) {
        this.envId = envId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
}
