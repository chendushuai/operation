package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaAffiliation;
import com.mysql.cj.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OperaAffiliationResponse {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 主键
     */
    private Integer id;

    /**
     * 归属名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private String createTimeStr;
    private String modifyTimeStr;

    public OperaAffiliationResponse(OperaAffiliation operaAffiliation) {
        this.id=operaAffiliation.getId();
        this.name=operaAffiliation.getName();
        this.desc=operaAffiliation.getDesc();
        this.createTime=operaAffiliation.getCreateTime();
        this.modifyTime=operaAffiliation.getModifyTime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
}
