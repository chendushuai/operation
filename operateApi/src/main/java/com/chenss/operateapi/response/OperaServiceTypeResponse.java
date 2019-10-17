package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.model.OperaServiceType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperaServiceTypeResponse {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
    /**
     * 主键
     */
    private Integer id;

    /**
     * 服务类型
     */
    private String serviceType;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务描述
     */
    private String serviceDesc;

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

    public OperaServiceTypeResponse(OperaServiceType operaServiceType) {
        this.id=operaServiceType.getId();
        this.serviceType=operaServiceType.getServiceType();
        this.serviceName=operaServiceType.getServiceName();
        this.serviceDesc=operaServiceType.getServiceDesc();
        this.createTime=operaServiceType.getCreateTime();
        this.modifyTime=operaServiceType.getModifytime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
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
