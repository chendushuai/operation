package com.chenss.operateapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_application
 * @author 
 */
public class OperaApplication implements Serializable {
    /**
     * 应用ID
     */
    private String id;

    /**
     * CMDB中的应用ID
     */
    private String appCmdbId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用类型（dubbo、nginx等）
     */
    private String appType;

    /**
     * 仓库类型
     */
    private String repoType;

    /**
     * SVN地址
     */
    private String svnUrl;

    /**
     * GIT地址
     */
    private String gitUrl;

    /**
     * JDK版本
     */
    private String jdkVersion;

    /**
     * 应用归属
     */
    private Integer appAffiliationId;

    /**
     * 应用负责人
     */
    private String appPrincipal;

    /**
     * 应用用途描述
     */
    private String appPurpose;

    /**
     * 应用备注内容
     */
    private String appRemark;

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

    public String getAppCmdbId() {
        return appCmdbId;
    }

    public void setAppCmdbId(String appCmdbId) {
        this.appCmdbId = appCmdbId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getRepoType() {
        return repoType;
    }

    public void setRepoType(String repoType) {
        this.repoType = repoType;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getJdkVersion() {
        return jdkVersion;
    }

    public void setJdkVersion(String jdkVersion) {
        this.jdkVersion = jdkVersion;
    }

    public Integer getAppAffiliationId() {
        return appAffiliationId;
    }

    public void setAppAffiliationId(Integer appAffiliationId) {
        this.appAffiliationId = appAffiliationId;
    }

    public String getAppPrincipal() {
        return appPrincipal;
    }

    public void setAppPrincipal(String appPrincipal) {
        this.appPrincipal = appPrincipal;
    }

    public String getAppPurpose() {
        return appPurpose;
    }

    public void setAppPurpose(String appPurpose) {
        this.appPurpose = appPurpose;
    }

    public String getAppRemark() {
        return appRemark;
    }

    public void setAppRemark(String appRemark) {
        this.appRemark = appRemark;
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
        OperaApplication other = (OperaApplication) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppCmdbId() == null ? other.getAppCmdbId() == null : this.getAppCmdbId().equals(other.getAppCmdbId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getAppType() == null ? other.getAppType() == null : this.getAppType().equals(other.getAppType()))
            && (this.getRepoType() == null ? other.getRepoType() == null : this.getRepoType().equals(other.getRepoType()))
            && (this.getSvnUrl() == null ? other.getSvnUrl() == null : this.getSvnUrl().equals(other.getSvnUrl()))
            && (this.getGitUrl() == null ? other.getGitUrl() == null : this.getGitUrl().equals(other.getGitUrl()))
            && (this.getJdkVersion() == null ? other.getJdkVersion() == null : this.getJdkVersion().equals(other.getJdkVersion()))
            && (this.getAppAffiliationId() == null ? other.getAppAffiliationId() == null : this.getAppAffiliationId().equals(other.getAppAffiliationId()))
            && (this.getAppPrincipal() == null ? other.getAppPrincipal() == null : this.getAppPrincipal().equals(other.getAppPrincipal()))
            && (this.getAppPurpose() == null ? other.getAppPurpose() == null : this.getAppPurpose().equals(other.getAppPurpose()))
            && (this.getAppRemark() == null ? other.getAppRemark() == null : this.getAppRemark().equals(other.getAppRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppCmdbId() == null) ? 0 : getAppCmdbId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
        result = prime * result + ((getRepoType() == null) ? 0 : getRepoType().hashCode());
        result = prime * result + ((getSvnUrl() == null) ? 0 : getSvnUrl().hashCode());
        result = prime * result + ((getGitUrl() == null) ? 0 : getGitUrl().hashCode());
        result = prime * result + ((getJdkVersion() == null) ? 0 : getJdkVersion().hashCode());
        result = prime * result + ((getAppAffiliationId() == null) ? 0 : getAppAffiliationId().hashCode());
        result = prime * result + ((getAppPrincipal() == null) ? 0 : getAppPrincipal().hashCode());
        result = prime * result + ((getAppPurpose() == null) ? 0 : getAppPurpose().hashCode());
        result = prime * result + ((getAppRemark() == null) ? 0 : getAppRemark().hashCode());
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
        sb.append(", appCmdbId=").append(appCmdbId);
        sb.append(", appName=").append(appName);
        sb.append(", appType=").append(appType);
        sb.append(", repoType=").append(repoType);
        sb.append(", svnUrl=").append(svnUrl);
        sb.append(", gitUrl=").append(gitUrl);
        sb.append(", jdkVersion=").append(jdkVersion);
        sb.append(", appAffiliationId=").append(appAffiliationId);
        sb.append(", appPrincipal=").append(appPrincipal);
        sb.append(", appPurpose=").append(appPurpose);
        sb.append(", appRemark=").append(appRemark);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}