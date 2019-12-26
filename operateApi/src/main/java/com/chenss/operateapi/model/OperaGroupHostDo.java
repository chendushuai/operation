package com.chenss.operateapi.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenss002
 * @date 2019-10-23 14:28:53
 */
public class OperaGroupHostDo implements Serializable {
    private static final long serialVersionUID = -4721980313755411261L;
    /**
     * 分组ID
     */
    @Getter
    @Setter
    private String id;

    /**
     * 分组类型（主机分组、域名分组）
     */
    @Getter
    @Setter
    private String groupType;

    /**
     * 分组名称
     */
    @Getter
    @Setter
    private String groupName;
    /**
     * 创建时间
     */
    @Getter
    @Setter
    private Date createTime;

    /**
     * 修改时间
     */
    @Getter
    @Setter
    private Date modifyTime;
    @Getter
    @Setter
    private String hostInfo;
}
