package com.chenss.operateapi.param;

import com.chenss.operateapi.common.RequestParam;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签分页查询参数
 * @author chenss002
 * @date 2019-10-22 16:25:02
 */
@Getter
@Setter
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
}
