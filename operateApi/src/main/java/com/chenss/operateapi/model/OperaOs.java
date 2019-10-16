package com.chenss.operateapi.model;

import java.io.Serializable;

/**
 * opera_os
 * @author 
 */
public class OperaOs implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 系统名称
     */
    private String osName;

    /**
     * 系统版本
     */
    private String osVersion;

    /**
     * 系统备注内容
     */
    private String osRemark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsRemark() {
        return osRemark;
    }

    public void setOsRemark(String osRemark) {
        this.osRemark = osRemark;
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
        OperaOs other = (OperaOs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getOsRemark() == null ? other.getOsRemark() == null : this.getOsRemark().equals(other.getOsRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getOsRemark() == null) ? 0 : getOsRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", osName=").append(osName);
        sb.append(", osVersion=").append(osVersion);
        sb.append(", osRemark=").append(osRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}