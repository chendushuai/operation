package com.chenss.operateapi.param;

import com.chenss.operateapi.common.RequestParam;

import java.io.Serializable;

/**
 * 查询分组和主机明细信息查询条件
 * @author chenss002
 * @date 2019-10-23 10:51:51
 */
public class GroupApplicationParam extends PagerParam implements Serializable, RequestParam {
    private static final long serialVersionUID = 3688440841465757369L;
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
