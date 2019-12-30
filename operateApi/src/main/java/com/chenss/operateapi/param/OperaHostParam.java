package com.chenss.operateapi.param;

import com.chenss.operateapi.common.RequestParam;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OperaHostParam extends PagerParam implements Serializable, RequestParam {
    /**
     * 主键
     */
    private String id;

    /**
     * 主机名称
     */
    private String hostName;

    /**
     * 主机IP
     */
    private String hostIp;

    /**
     * 主机机器类型
     */
    private String hostType;

    /**
     * 状态  0-启用，1-禁用，2-删除
     */
    private Integer status;

    /**
     * 主机CPU大小
     */
    private String hostCpu;

    /**
     * 主机内存大小
     */
    private String hostMemory;

    /**
     * 主机硬盘大小
     */
    private String hostHarddisk;
    private Integer hostOsId;
    private Integer hostEnvId;
    private Integer hostAffiliationId;
    private Integer serviceType;
    private String createTimeBegin;
    private String createTimeEnd;
    private String modifyTimeBegin;
    private String modifyTimeEnd;
}
