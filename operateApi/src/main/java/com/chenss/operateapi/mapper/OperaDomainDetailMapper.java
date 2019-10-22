package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaDomainDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaDomainDetailMapper继承基类
 */
@Mapper
public interface OperaDomainDetailMapper extends MyBatisBaseDao<OperaDomainDetail, String> {
    List<OperaDomainDetail> query(OperaDomainDetail obj);
}