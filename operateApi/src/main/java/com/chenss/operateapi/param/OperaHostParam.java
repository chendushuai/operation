package com.chenss.operateapi.param;

import java.io.Serializable;

public class OperaHostParam extends PagerParam implements Serializable {
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
    private Integer hostOsId;
    private Integer hostEnvId;
    private Integer hostAffiliationId;
    private Integer serviceType;
    private String createTimeBegin;
    private String createTimeEnd;
    private String modifyTimeBegin;
    private String modifyTimeEnd;

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

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getModifyTimeBegin() {
        return modifyTimeBegin;
    }

    public void setModifyTimeBegin(String modifyTimeBegin) {
        this.modifyTimeBegin = modifyTimeBegin;
    }

    public String getModifyTimeEnd() {
        return modifyTimeEnd;
    }

    public void setModifyTimeEnd(String modifyTimeEnd) {
        this.modifyTimeEnd = modifyTimeEnd;
    }
}
