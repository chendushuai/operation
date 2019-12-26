package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.model.OperaServiceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 主机信息相应结果
 * @author chenss002
 */
public class OperaHostResponse {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 主键
     */
    @Getter
    @Setter
    private String id;

    /**
     * 主机名称
     */
    @Getter
    @Setter
    private String hostName;

    /**
     * 主机IP
     */
    @Getter
    @Setter
    private String hostIp;

    /**
     * 主机机器类型
     */
    @Getter
    @Setter
    private String hostType;

    /**
     * 主机说明
     */
    @Getter
    @Setter
    private String hostRemark;

    /**
     * 状态  0-启用，1-禁用，2-删除
     */
    @Getter
    @Setter
    private Integer status;

    /**
     * 主机CPU大小
     */
    @Getter
    @Setter
    private String hostCpu;

    /**
     * 主机内存大小
     */
    @Getter
    @Setter
    private String hostMemory;

    /**
     * 主机硬盘大小
     */
    @Getter
    @Setter
    private String hostHarddisk;

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
    /**
     * 系统名称
     */
    @Getter
    @Setter
    private String osName;
    /**
     * 系统版本
     */
    @Getter
    @Setter
    private String osVersion;

    /**
     * 主机所属环境
     */
    @Getter
    @Setter
    private String envName;
    /**
     * 主机归属
     */
    @Getter
    @Setter
    private String affName;
    /**
     * 所属区域类型
     */
    @Getter
    @Setter
    private String serviceType;
    /**
     * 所属区域类型名称
     */
    @Getter
    @Setter
    private String serviceName;

    private String createTimeStr;
    private String modifyTimeStr;

    public OperaHostResponse(OperaHost operaHost) {
        BeanUtils.copyProperties(operaHost,this);
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCreateTimeStr() {
        if (null == this.createTime) {
            return "";
        }

        return simpleDateFormat.format(this.createTime);
    }

    public String getModifyTimeStr() {
        if (null == this.modifyTime) {
            return "";
        }

        return simpleDateFormat.format(this.modifyTime);
    }

    public static List<OperaHostResponse> convertList(List<OperaHost> operaHosts) {
        List<OperaHostResponse> result = new ArrayList<>();
        for (OperaHost operaHostItem :
                operaHosts) {
            result.add(new OperaHostResponse(operaHostItem));
        }
        return result;
    }
}
