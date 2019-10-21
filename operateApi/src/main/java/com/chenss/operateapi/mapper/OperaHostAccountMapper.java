package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaHostAccount;
import org.springframework.stereotype.Repository;

/**
 * OperaHostAccountMapper继承基类
 */
@Repository
public interface OperaHostAccountMapper extends MyBatisBaseDao<OperaHostAccount, String> {
}