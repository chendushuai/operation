package com.chenss.operateapi.param;

import com.chenss.operateapi.common.RequestParam;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签分页查询参数
 * @author chenss002
 * @date 2019-10-22 16:25:02
 */
public class OperaLabelPageParam extends PagerParam implements Serializable, RequestParam {
    private static final long serialVersionUID = -8889147935199709314L;
    /**
     * ID
     */
    private String id;

    /**
     * 键值分组
     */
    private String labelGroup;

    /**
     * 键
     */
    private String labelKey;

    /**
     * 值
     */
    private String labelValue;

    /**
     * 说明
     */
    private String labelDesc;

    /**
     * 备注
     */
    private String labelRemark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelGroup() {
        return labelGroup;
    }

    public void setLabelGroup(String labelGroup) {
        this.labelGroup = labelGroup;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc;
    }

    public String getLabelRemark() {
        return labelRemark;
    }

    public void setLabelRemark(String labelRemark) {
        this.labelRemark = labelRemark;
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
}
