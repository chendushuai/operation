package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_domain
 * @author 
 */
public class OperaDomain implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 域名地址
     */
    private String domainUrl;

    /**
     * 访问控制类型
     */
    private String visitControl;

    /**
     * 域名负责人
     */
    private String domainPrincipal;

    /**
     * 域名适用环境
     */
    private String domainEnv;

    /**
     * 域名配置策略
     */
    private String configurationStrategy;

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

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public String getVisitControl() {
        return visitControl;
    }

    public void setVisitControl(String visitControl) {
        this.visitControl = visitControl;
    }

    public String getDomainPrincipal() {
        return domainPrincipal;
    }

    public void setDomainPrincipal(String domainPrincipal) {
        this.domainPrincipal = domainPrincipal;
    }

    public String getDomainEnv() {
        return domainEnv;
    }

    public void setDomainEnv(String domainEnv) {
        this.domainEnv = domainEnv;
    }

    public String getConfigurationStrategy() {
        return configurationStrategy;
    }

    public void setConfigurationStrategy(String configurationStrategy) {
        this.configurationStrategy = configurationStrategy;
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
        OperaDomain other = (OperaDomain) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDomainUrl() == null ? other.getDomainUrl() == null : this.getDomainUrl().equals(other.getDomainUrl()))
            && (this.getVisitControl() == null ? other.getVisitControl() == null : this.getVisitControl().equals(other.getVisitControl()))
            && (this.getDomainPrincipal() == null ? other.getDomainPrincipal() == null : this.getDomainPrincipal().equals(other.getDomainPrincipal()))
            && (this.getDomainEnv() == null ? other.getDomainEnv() == null : this.getDomainEnv().equals(other.getDomainEnv()))
            && (this.getConfigurationStrategy() == null ? other.getConfigurationStrategy() == null : this.getConfigurationStrategy().equals(other.getConfigurationStrategy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDomainUrl() == null) ? 0 : getDomainUrl().hashCode());
        result = prime * result + ((getVisitControl() == null) ? 0 : getVisitControl().hashCode());
        result = prime * result + ((getDomainPrincipal() == null) ? 0 : getDomainPrincipal().hashCode());
        result = prime * result + ((getDomainEnv() == null) ? 0 : getDomainEnv().hashCode());
        result = prime * result + ((getConfigurationStrategy() == null) ? 0 : getConfigurationStrategy().hashCode());
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
        sb.append(", domainUrl=").append(domainUrl);
        sb.append(", visitControl=").append(visitControl);
        sb.append(", domainPrincipal=").append(domainPrincipal);
        sb.append(", domainEnv=").append(domainEnv);
        sb.append(", configurationStrategy=").append(configurationStrategy);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}