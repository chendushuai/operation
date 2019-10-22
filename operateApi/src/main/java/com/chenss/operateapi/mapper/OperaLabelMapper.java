package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaLabel;
import com.chenss.operateapi.param.OperaLabelPageParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaLabelMapper继承基类
 */
@Mapper
public interface OperaLabelMapper extends MyBatisBaseDao<OperaLabel, String> {
    List<OperaLabel> query(OperaLabel obj);
    List<OperaLabel> listPaging(OperaLabelPageParam obj);
    int countListPaging(OperaLabelPageParam obj);
}