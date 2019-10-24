package com.chenss.operateapi.response;

import java.io.Serializable;

/**
 * 环境和主机信息实体
 * @author chenss002
 * @date 2019-10-23 10:35:49
 */
public class EnvHostDO implements Serializable {
    private static final long serialVersionUID = 5864218166171270016L;
    private String id;
    private String envType;
    private String envName;
    private String hostName;
    private String hostIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnvType() {
        return envType;
    }

    public void setEnvType(String envType) {
        this.envType = envType;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    @Override
    public String toString() {
        return "EnvHostDO{" +
                "id='" + id + '\'' +
                ", envType='" + envType + '\'' +
                ", envName='" + envName + '\'' +
                ", hostName='" + hostName + '\'' +
                ", hostIp='" + hostIp + '\'' +
                '}';
    }
}
