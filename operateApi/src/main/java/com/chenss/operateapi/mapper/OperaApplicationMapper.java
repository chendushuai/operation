package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaApplication;
import org.springframework.stereotype.Repository;

/**
 * OperaApplicationMapper继承基类
 */
@Repository
public interface OperaApplicationMapper extends MyBatisBaseDao<OperaApplication, String> {
}