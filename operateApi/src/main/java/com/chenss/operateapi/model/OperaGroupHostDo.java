package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenss002
 * @date 2019-10-23 14:28:53
 */
public class OperaGroupHostDo implements Serializable {
    private static final long serialVersionUID = -4721980313755411261L;
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
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private String hostInfo;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getHostInfo() {
        return hostInfo;
    }

    public void setHostInfo(String hostInfo) {
        this.hostInfo = hostInfo;
    }
}
