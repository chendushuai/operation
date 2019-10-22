package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaHostAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaHostAccountMapper继承基类
 */
@Mapper
public interface OperaHostAccountMapper extends MyBatisBaseDao<OperaHostAccount, String> {
    List<OperaHostAccount> query(OperaHostAccount obj);
}