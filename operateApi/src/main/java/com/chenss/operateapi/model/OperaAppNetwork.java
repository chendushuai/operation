package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_app_network
 * @author 
 */
public class OperaAppNetwork implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 源应用ID
     */
    private String appSourceId;

    /**
     * 目标应用ID
     */
    private String appTargetId;

    /**
     * 是否访问互联网(0-否|1-是)
     */
    private Integer internetVisit;

    /**
     * 连接用途
     */
    private String linkUse;

    /**
     * 说明
     */
    private String remark;

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

    public String getAppSourceId() {
        return appSourceId;
    }

    public void setAppSourceId(String appSourceId) {
        this.appSourceId = appSourceId;
    }

    public String getAppTargetId() {
        return appTargetId;
    }

    public void setAppTargetId(String appTargetId) {
        this.appTargetId = appTargetId;
    }

    public Integer getInternetVisit() {
        return internetVisit;
    }

    public void setInternetVisit(Integer internetVisit) {
        this.internetVisit = internetVisit;
    }

    public String getLinkUse() {
        return linkUse;
    }

    public void setLinkUse(String linkUse) {
        this.linkUse = linkUse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OperaAppNetwork other = (OperaAppNetwork) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppSourceId() == null ? other.getAppSourceId() == null : this.getAppSourceId().equals(other.getAppSourceId()))
            && (this.getAppTargetId() == null ? other.getAppTargetId() == null : this.getAppTargetId().equals(other.getAppTargetId()))
            && (this.getInternetVisit() == null ? other.getInternetVisit() == null : this.getInternetVisit().equals(other.getInternetVisit()))
            && (this.getLinkUse() == null ? other.getLinkUse() == null : this.getLinkUse().equals(other.getLinkUse()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppSourceId() == null) ? 0 : getAppSourceId().hashCode());
        result = prime * result + ((getAppTargetId() == null) ? 0 : getAppTargetId().hashCode());
        result = prime * result + ((getInternetVisit() == null) ? 0 : getInternetVisit().hashCode());
        result = prime * result + ((getLinkUse() == null) ? 0 : getLinkUse().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appSourceId=").append(appSourceId);
        sb.append(", appTargetId=").append(appTargetId);
        sb.append(", internetVisit=").append(internetVisit);
        sb.append(", linkUse=").append(linkUse);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}