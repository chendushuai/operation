package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaDomainMapper继承基类
 */
@Mapper
public interface OperaDomainMapper extends MyBatisBaseDao<OperaDomain, String> {
    List<OperaDomain> query(OperaDomain obj);
}