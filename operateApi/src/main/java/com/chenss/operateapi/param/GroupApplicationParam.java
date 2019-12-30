package com.chenss.operateapi.param;

import com.chenss.operateapi.common.RequestParam;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 查询分组和主机明细信息查询条件
 * @author chenss002
 * @date 2019-10-23 10:51:51
 */
@Getter
@Setter
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
}
