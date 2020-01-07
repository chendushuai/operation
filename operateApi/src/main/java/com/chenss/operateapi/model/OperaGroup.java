package com.chenss.operateapi.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_group
 * @author 
 */
@Getter
@Setter
public class OperaGroup implements Serializable {
    private static final long serialVersionUID = 1122997213153418057L;
    /**
     * 分组ID
     */
    private String id;

    /**
     * 分组类型（主机分组、域名分组）
     */
    private String groupType;

    /**
     * 分组类型名称
     */
    private String groupTypeName;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 分组说明
     */
    private String groupRemark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}