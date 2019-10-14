package com.chenss.operateapi.model;

import com.chenss.operateapi.param.TimeCommonParam;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_service_type
 * @author 
 */
public class OperaServiceType extends TimeCommonParam implements Serializable {
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

    private static final long serialVersionUID = 1L;

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

    public Date getModifytime() {
        return modifyTime;
    }

    public void setModifytime(Date modifyTime) {
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
        OperaServiceType other = (OperaServiceType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getServiceType() == null ? other.getServiceType() == null : this.getServiceType().equals(other.getServiceType()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getServiceDesc() == null ? other.getServiceDesc() == null : this.getServiceDesc().equals(other.getServiceDesc()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifytime() == null ? other.getModifytime() == null : this.getModifytime().equals(other.getModifytime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getServiceType() == null) ? 0 : getServiceType().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getServiceDesc() == null) ? 0 : getServiceDesc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifytime() == null) ? 0 : getModifytime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", serviceDesc=").append(serviceDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}