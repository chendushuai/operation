package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_label
 * @author 
 */
public class OperaLabel implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 键值分组
     */
    private String labelGroup;

    /**
     * 键
     */
    private String labelKey;

    /**
     * 值
     */
    private String labelValue;

    /**
     * 说明
     */
    private String labelDesc;

    /**
     * 备注
     */
    private String labelRemark;

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

    public String getLabelGroup() {
        return labelGroup;
    }

    public void setLabelGroup(String labelGroup) {
        this.labelGroup = labelGroup;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc;
    }

    public String getLabelRemark() {
        return labelRemark;
    }

    public void setLabelRemark(String labelRemark) {
        this.labelRemark = labelRemark;
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
        OperaLabel other = (OperaLabel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLabelGroup() == null ? other.getLabelGroup() == null : this.getLabelGroup().equals(other.getLabelGroup()))
            && (this.getLabelKey() == null ? other.getLabelKey() == null : this.getLabelKey().equals(other.getLabelKey()))
            && (this.getLabelValue() == null ? other.getLabelValue() == null : this.getLabelValue().equals(other.getLabelValue()))
            && (this.getLabelDesc() == null ? other.getLabelDesc() == null : this.getLabelDesc().equals(other.getLabelDesc()))
            && (this.getLabelRemark() == null ? other.getLabelRemark() == null : this.getLabelRemark().equals(other.getLabelRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLabelGroup() == null) ? 0 : getLabelGroup().hashCode());
        result = prime * result + ((getLabelKey() == null) ? 0 : getLabelKey().hashCode());
        result = prime * result + ((getLabelValue() == null) ? 0 : getLabelValue().hashCode());
        result = prime * result + ((getLabelDesc() == null) ? 0 : getLabelDesc().hashCode());
        result = prime * result + ((getLabelRemark() == null) ? 0 : getLabelRemark().hashCode());
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
        sb.append(", labelGroup=").append(labelGroup);
        sb.append(", labelKey=").append(labelKey);
        sb.append(", labelValue=").append(labelValue);
        sb.append(", labelDesc=").append(labelDesc);
        sb.append(", labelRemark=").append(labelRemark);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}