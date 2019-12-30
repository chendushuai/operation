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
public class GroupHostParam extends PagerParam implements Serializable, RequestParam {
    /**
     * 分组ID
     */
    private String id;

    /**
     * 分组类型（主机分组、域名分组）
     */
    private String groupType;

    /**
     * 分组名称
     */
    private String groupName;
    private Integer envId;
    private String hostName;
    private String hostIp;
}
