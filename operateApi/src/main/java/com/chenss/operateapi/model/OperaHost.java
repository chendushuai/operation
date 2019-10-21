package com.chenss.operateapi.model;

import com.chenss.operateapi.param.TimeCommonParam;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    private Integer hostOsId;
    private Integer hostEnvId;
    private Integer hostAffiliationId;
    private Integer hostServiceType;

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

    public Integer getHostServiceType() {
        return hostServiceType;
    }

    public void setHostServiceType(Integer hostServiceType) {
        this.hostServiceType = hostServiceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperaHost operaHost = (OperaHost) o;
        return Objects.equals(id, operaHost.id) &&
                Objects.equals(hostName, operaHost.hostName) &&
                Objects.equals(hostIp, operaHost.hostIp) &&
                Objects.equals(hostType, operaHost.hostType) &&
                Objects.equals(hostRemark, operaHost.hostRemark) &&
                Objects.equals(status, operaHost.status) &&
                Objects.equals(hostCpu, operaHost.hostCpu) &&
                Objects.equals(hostMemory, operaHost.hostMemory) &&
                Objects.equals(hostHarddisk, operaHost.hostHarddisk) &&
                Objects.equals(createTime, operaHost.createTime) &&
                Objects.equals(modifyTime, operaHost.modifyTime) &&
                Objects.equals(osName, operaHost.osName) &&
                Objects.equals(osVersion, operaHost.osVersion) &&
                Objects.equals(envName, operaHost.envName) &&
                Objects.equals(affName, operaHost.affName) &&
                Objects.equals(serviceType, operaHost.serviceType) &&
                Objects.equals(serviceName, operaHost.serviceName) &&
                Objects.equals(hostOsId, operaHost.hostOsId) &&
                Objects.equals(hostEnvId, operaHost.hostEnvId) &&
                Objects.equals(hostAffiliationId, operaHost.hostAffiliationId) &&
                Objects.equals(hostServiceType, operaHost.hostServiceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hostName, hostIp, hostType, hostRemark, status, hostCpu, hostMemory, hostHarddisk, createTime, modifyTime, osName, osVersion, envName, affName, serviceType, serviceName, hostOsId, hostEnvId, hostAffiliationId, hostServiceType);
    }

    @Override
    public String toString() {
        return "OperaHost{" +
                "id='" + id + '\'' +
                ", hostName='" + hostName + '\'' +
                ", hostIp='" + hostIp + '\'' +
                ", hostType='" + hostType + '\'' +
                ", hostRemark='" + hostRemark + '\'' +
                ", status=" + status +
                ", hostCpu='" + hostCpu + '\'' +
                ", hostMemory='" + hostMemory + '\'' +
                ", hostHarddisk='" + hostHarddisk + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", envName='" + envName + '\'' +
                ", affName='" + affName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", hostOsId=" + hostOsId +
                ", hostEnvId=" + hostEnvId +
                ", hostAffiliationId=" + hostAffiliationId +
                ", hostServiceType=" + hostServiceType +
                '}';
    }
}