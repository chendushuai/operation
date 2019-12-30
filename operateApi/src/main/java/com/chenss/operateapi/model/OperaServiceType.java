package com.chenss.operateapi.model;

import com.chenss.operateapi.param.TimeCommonParam;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * opera_service_type
 * @author
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OperaServiceType extends TimeCommonParam implements Serializable {

    private static final long serialVersionUID = 6154493946438215708L;
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
}