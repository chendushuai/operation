package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaDomain;
import org.springframework.stereotype.Repository;

/**
 * OperaDomainMapper继承基类
 */
@Repository
public interface OperaDomainMapper extends MyBatisBaseDao<OperaDomain, String> {
}