package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.model.OperaServiceType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperaHostResponse {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private String createTimeStr;
    private String modifyTimeStr;

    public OperaHostResponse(OperaHost operaHost) {
        this.id=operaHost.getId();
        this.hostName=operaHost.getHostName();
        this.hostIp=operaHost.getHostIp();
        this.hostUse=operaHost.getHostUse();
        this.hostRemark=operaHost.getHostRemark();
        this.status=operaHost.getStatus();
        this.hostCpu=operaHost.getHostCpu();
        this.hostMemory=operaHost.getHostMemory();
        this.hostHarddisk=operaHost.getHostHarddisk();
        this.hostOsId=operaHost.getHostOsId();
        this.hostEnvId=operaHost.getHostEnvId();
        this.hostAffiliationId=operaHost.getHostAffiliationId();
        this.createTime=operaHost.getCreateTime();
        this.modifyTime=operaHost.getModifyTime();
    }

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

    public String getCreateTimeStr() {
        if (null == this.createTime) {
            return "";
        }

        return simpleDateFormat.format(this.createTime);
    }

    public String getModifyTimeStr() {
        if (null == this.modifyTime) {
            return "";
        }

        return simpleDateFormat.format(this.modifyTime);
    }
}
