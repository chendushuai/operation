package com.chenss.operateapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 环境和主机信息实体
 * @author chenss002
 * @date 2019-10-23 10:35:49
 */
@ToString
@Getter
@Setter
public class EnvHostDO implements Serializable {
    private static final long serialVersionUID = 5864218166171270016L;
    private String id;
    private String envType;
    private String envName;
    private String hostName;
    private String hostIp;
}
