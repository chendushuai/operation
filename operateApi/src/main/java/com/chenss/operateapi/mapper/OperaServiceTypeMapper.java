package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaServiceType;
import org.springframework.stereotype.Repository;

/**
 * OperaServiceTypeMapper继承基类
 */
@Repository
public interface OperaServiceTypeMapper extends MyBatisBaseDao<OperaServiceType, Integer> {
}