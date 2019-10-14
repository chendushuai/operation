package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaServiceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * OperaServiceTypeMapper继承基类
 */
@Mapper
public interface OperaServiceTypeMapper extends MyBatisBaseDao<OperaServiceType, Integer> {
    List<OperaServiceType> query(OperaServiceType obj);
}