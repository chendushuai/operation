package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaDomainDetail;
import org.springframework.stereotype.Repository;

/**
 * OperaDomainDetailMapper继承基类
 */
@Repository
public interface OperaDomainDetailMapper extends MyBatisBaseDao<OperaDomainDetail, String> {
}