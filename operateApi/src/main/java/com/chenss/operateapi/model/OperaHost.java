package com.chenss.operateapi.model;

import java.io.Serializable;

/**
 * opera_host
 * @author 
 */
public class OperaHost implements Serializable {
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
     * 主机用途
     */
    private String hostUse;

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
     * 主机系统类型
     */
    private Integer hostOsId;

    /**
     * 主机所属环境
     */
    private Integer hostEnvId;

    /**
     * 主机归属
     */
    private Integer hostAffiliationId;

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

    public String getHostUse() {
        return hostUse;
    }

    public void setHostUse(String hostUse) {
        this.hostUse = hostUse;
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

    public Integer getHostOsId() {
        return hostOsId;
    }

    public void setHostOsId(Integer hostOsId) {
        this.hostOsId = hostOsId;
    }

    public Integer getHostEnvId() {
        return hostEnvId;
    }

    public void setHostEnvId(Integer hostEnvId) {
        this.hostEnvId = hostEnvId;
    }

    public Integer getHostAffiliationId() {
        return hostAffiliationId;
    }

    public void setHostAffiliationId(Integer hostAffiliationId) {
        this.hostAffiliationId = hostAffiliationId;
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
            && (this.getHostUse() == null ? other.getHostUse() == null : this.getHostUse().equals(other.getHostUse()))
            && (this.getHostRemark() == null ? other.getHostRemark() == null : this.getHostRemark().equals(other.getHostRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHostCpu() == null ? other.getHostCpu() == null : this.getHostCpu().equals(other.getHostCpu()))
            && (this.getHostMemory() == null ? other.getHostMemory() == null : this.getHostMemory().equals(other.getHostMemory()))
            && (this.getHostHarddisk() == null ? other.getHostHarddisk() == null : this.getHostHarddisk().equals(other.getHostHarddisk()))
            && (this.getHostOsId() == null ? other.getHostOsId() == null : this.getHostOsId().equals(other.getHostOsId()))
            && (this.getHostEnvId() == null ? other.getHostEnvId() == null : this.getHostEnvId().equals(other.getHostEnvId()))
            && (this.getHostAffiliationId() == null ? other.getHostAffiliationId() == null : this.getHostAffiliationId().equals(other.getHostAffiliationId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHostName() == null) ? 0 : getHostName().hashCode());
        result = prime * result + ((getHostIp() == null) ? 0 : getHostIp().hashCode());
        result = prime * result + ((getHostUse() == null) ? 0 : getHostUse().hashCode());
        result = prime * result + ((getHostRemark() == null) ? 0 : getHostRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHostCpu() == null) ? 0 : getHostCpu().hashCode());
        result = prime * result + ((getHostMemory() == null) ? 0 : getHostMemory().hashCode());
        result = prime * result + ((getHostHarddisk() == null) ? 0 : getHostHarddisk().hashCode());
        result = prime * result + ((getHostOsId() == null) ? 0 : getHostOsId().hashCode());
        result = prime * result + ((getHostEnvId() == null) ? 0 : getHostEnvId().hashCode());
        result = prime * result + ((getHostAffiliationId() == null) ? 0 : getHostAffiliationId().hashCode());
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
        sb.append(", hostUse=").append(hostUse);
        sb.append(", hostRemark=").append(hostRemark);
        sb.append(", status=").append(status);
        sb.append(", hostCpu=").append(hostCpu);
        sb.append(", hostMemory=").append(hostMemory);
        sb.append(", hostHarddisk=").append(hostHarddisk);
        sb.append(", hostOsId=").append(hostOsId);
        sb.append(", hostEnvId=").append(hostEnvId);
        sb.append(", hostAffiliationId=").append(hostAffiliationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}