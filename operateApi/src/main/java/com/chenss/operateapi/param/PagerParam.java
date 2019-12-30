package com.chenss.operateapi.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 分页查询公共类
 * @author chenss002
 * @date 2019-10-23 11:03:47
 */
@Getter
@Setter
public class PagerParam implements Serializable {
    private int pageSize = 20;
    /**
     * 页码，从0开始
     */
    private int pageIndex = 0;
    private int pageBegin;
}
