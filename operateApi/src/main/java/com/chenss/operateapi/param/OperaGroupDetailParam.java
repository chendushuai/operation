package com.chenss.operateapi.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author chenss002
 */
@Getter
@Setter
public class OperaGroupDetailParam implements Serializable {
    private static final long serialVersionUID = -1370038123704512176L;
    /**
     * 分组关系ID
     */
    private String id;

    /**
     * 对象ID，主机或域名等ID
     */
    private String itemId;

    /**
     * 分组ID
     */
    private String groupId;

    private String hostId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;
}
