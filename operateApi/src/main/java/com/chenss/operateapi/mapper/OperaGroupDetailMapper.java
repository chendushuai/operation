package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaGroupDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaGroupDetailMapper继承基类
 */
@Mapper
public interface OperaGroupDetailMapper extends MyBatisBaseDao<OperaGroupDetail, String> {
    List<OperaGroupDetail> query(OperaGroupDetail obj);
}