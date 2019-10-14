package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaHost;
import org.springframework.stereotype.Repository;

/**
 * OperaHostMapper继承基类
 */
@Repository
public interface OperaHostMapper extends MyBatisBaseDao<OperaHost, String> {
}