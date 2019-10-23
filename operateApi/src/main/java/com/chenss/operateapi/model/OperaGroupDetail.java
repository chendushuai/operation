package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * opera_group_detail
 * @author 
 */
public class OperaGroupDetail implements Serializable {
    /**
     * 分组关系ID
     */
    private String id;

    /**
     * 对象ID，主机或域名等ID
     */
    private String itemId;

    /**
     * 分组ID
     */
    private String groupId;

    private List<String> hostIds;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getHostIds() {
        return hostIds;
    }

    public void setHostIds(List<String> hostIds) {
        this.hostIds = hostIds;
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
}