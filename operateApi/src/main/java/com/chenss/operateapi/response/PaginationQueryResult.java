package com.chenss.operateapi.response;

import java.io.Serializable;
import java.util.List;

public class PaginationQueryResult<T> implements Serializable {
    /**
     * 总记录数(符合查询条件的总记录数)
     */
    private int totalSize;

    /**
     * 分页后的结果列表
     */
    private List<T> resultList;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
