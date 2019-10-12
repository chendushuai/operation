package com.chenss.operateapi.model;

import java.io.Serializable;

/**
 * opera_env
 * @author 
 */
public class OperaEnv implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 环境类型
     */
    private String envType;

    /**
     * 环境名称
     */
    private String envName;

    /**
     * Apollo环境名称
     */
    private String apolloEnv;

    /**
     * 环境描述
     */
    private String envDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getApolloEnv() {
        return apolloEnv;
    }

    public void setApolloEnv(String apolloEnv) {
        this.apolloEnv = apolloEnv;
    }

    public String getEnvDesc() {
        return envDesc;
    }

    public void setEnvDesc(String envDesc) {
        this.envDesc = envDesc;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OperaEnv other = (OperaEnv) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnvType() == null ? other.getEnvType() == null : this.getEnvType().equals(other.getEnvType()))
            && (this.getEnvName() == null ? other.getEnvName() == null : this.getEnvName().equals(other.getEnvName()))
            && (this.getApolloEnv() == null ? other.getApolloEnv() == null : this.getApolloEnv().equals(other.getApolloEnv()))
            && (this.getEnvDesc() == null ? other.getEnvDesc() == null : this.getEnvDesc().equals(other.getEnvDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnvType() == null) ? 0 : getEnvType().hashCode());
        result = prime * result + ((getEnvName() == null) ? 0 : getEnvName().hashCode());
        result = prime * result + ((getApolloEnv() == null) ? 0 : getApolloEnv().hashCode());
        result = prime * result + ((getEnvDesc() == null) ? 0 : getEnvDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", envType=").append(envType);
        sb.append(", envName=").append(envName);
        sb.append(", apolloEnv=").append(apolloEnv);
        sb.append(", envDesc=").append(envDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}