package com.chenss.operateapi.model;

import com.chenss.operateapi.param.TimeCommonParam;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_host
 * @author 
 */
public class OperaHost extends TimeCommonParam implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 主机名称
     */
    private String hostName;

    /**
     * 主机IP
     */
    private String hostIp;

    /**
     * 主机机器类型
     */
    private String hostType;

    /**
     * 主机说明
     */
    private String hostRemark;

    /**
     * 状态  0-启用，1-禁用，2-删除
     */
    private Integer status;

    /**
     * 主机CPU大小
     */
    private String hostCpu;

    /**
     * 主机内存大小
     */
    private String hostMemory;

    /**
     * 主机硬盘大小
     */
    private String hostHarddisk;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 系统名称
     */
    private String osName;
    /**
     * 系统版本
     */
    private String osVersion;

    /**
     * 主机所属环境
     */
    private String envName;
    /**
     * 主机归属
     */
    private String affName;
    /**
     * 所属区域类型
     */
    private String serviceType;
    /**
     * 所属区域类型名称
     */
    private String serviceName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }

    public String getHostRemark() {
        return hostRemark;
    }

    public void setHostRemark(String hostRemark) {
        this.hostRemark = hostRemark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHostCpu() {
        return hostCpu;
    }

    public void setHostCpu(String hostCpu) {
        this.hostCpu = hostCpu;
    }

    public String getHostMemory() {
        return hostMemory;
    }

    public void setHostMemory(String hostMemory) {
        this.hostMemory = hostMemory;
    }

    public String getHostHarddisk() {
        return hostHarddisk;
    }

    public void setHostHarddisk(String hostHarddisk) {
        this.hostHarddisk = hostHarddisk;
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

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getAffName() {
        return affName;
    }

    public void setAffName(String affName) {
        this.affName = affName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        OperaHost other = (OperaHost) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHostName() == null ? other.getHostName() == null : this.getHostName().equals(other.getHostName()))
            && (this.getHostIp() == null ? other.getHostIp() == null : this.getHostIp().equals(other.getHostIp()))
            && (this.getHostType() == null ? other.getHostType() == null : this.getHostType().equals(other.getHostType()))
            && (this.getHostRemark() == null ? other.getHostRemark() == null : this.getHostRemark().equals(other.getHostRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHostCpu() == null ? other.getHostCpu() == null : this.getHostCpu().equals(other.getHostCpu()))
            && (this.getHostMemory() == null ? other.getHostMemory() == null : this.getHostMemory().equals(other.getHostMemory()))
            && (this.getHostHarddisk() == null ? other.getHostHarddisk() == null : this.getHostHarddisk().equals(other.getHostHarddisk()))
            && (this.getOsName() == null ? other.getOsName() == null : this.getOsName().equals(other.getOsName()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getEnvName() == null ? other.getEnvName() == null : this.getEnvName().equals(other.getEnvName()))
            && (this.getAffName() == null ? other.getAffName() == null : this.getAffName().equals(other.getAffName()))
            && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHostName() == null) ? 0 : getHostName().hashCode());
        result = prime * result + ((getHostIp() == null) ? 0 : getHostIp().hashCode());
        result = prime * result + ((getHostType() == null) ? 0 : getHostType().hashCode());
        result = prime * result + ((getHostRemark() == null) ? 0 : getHostRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHostCpu() == null) ? 0 : getHostCpu().hashCode());
        result = prime * result + ((getHostMemory() == null) ? 0 : getHostMemory().hashCode());
        result = prime * result + ((getHostHarddisk() == null) ? 0 : getHostHarddisk().hashCode());
        result = prime * result + ((getOsName() == null) ? 0 : getOsName().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getEnvName() == null) ? 0 : getEnvName().hashCode());
        result = prime * result + ((getAffName() == null) ? 0 : getAffName().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hostName=").append(hostName);
        sb.append(", hostIp=").append(hostIp);
        sb.append(", hostType=").append(hostType);
        sb.append(", hostRemark=").append(hostRemark);
        sb.append(", status=").append(status);
        sb.append(", hostCpu=").append(hostCpu);
        sb.append(", hostMemory=").append(hostMemory);
        sb.append(", hostHarddisk=").append(hostHarddisk);
        sb.append(", osName=").append(osName);
        sb.append(", osVersion=").append(osVersion);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", envName=").append(envName);
        sb.append(", affName=").append(affName);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}