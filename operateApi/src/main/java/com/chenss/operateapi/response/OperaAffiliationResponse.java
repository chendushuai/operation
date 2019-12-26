package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaAffiliation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 应用归属相应结果
 * @author chenss002
 */
public class OperaAffiliationResponse {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 主键
     */
    @Getter
    @Setter
    private Integer id;

    /**
     * 归属名称
     */
    @Getter
    @Setter
    private String name;

    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;

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

    private String createTimeStr;
    private String modifyTimeStr;

    public OperaAffiliationResponse(OperaAffiliation operaAffiliation) {
        BeanUtils.copyProperties(operaAffiliation,this);
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
