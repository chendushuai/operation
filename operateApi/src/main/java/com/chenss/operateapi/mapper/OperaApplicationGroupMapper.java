package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaApplicationGroup;
import org.springframework.stereotype.Repository;

/**
 * OperaApplicationGroupDAO继承基类
 */
@Repository
public interface OperaApplicationGroupMapper extends MyBatisBaseDao<OperaApplicationGroup, String> {
}