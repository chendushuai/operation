package com.chenss.operateapi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * opera_env
 * @author 
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OperaEnv implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 环境类型
     */
    @NotNull
    private String envType;

    /**
     * 环境名称
     */
    @NotNull
    private String envName;

    /**
     * Apollo环境名称
     */
    private String apolloEnv;

    /**
     * 环境描述
     */
    private String envDesc;
}