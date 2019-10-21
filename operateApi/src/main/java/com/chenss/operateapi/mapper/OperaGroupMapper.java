package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaGroup;
import org.springframework.stereotype.Repository;

/**
 * OperaGroupMapper继承基类
 */
@Repository
public interface OperaGroupMapper extends MyBatisBaseDao<OperaGroup, String> {
}