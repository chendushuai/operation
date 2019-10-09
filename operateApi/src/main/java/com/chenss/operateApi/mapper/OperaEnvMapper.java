package com.chenss.operateApi.mapper;

import com.chenss.operateApi.model.OperaEnv;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * OperaEnvMapper继承基类
 */
@Mapper
public interface OperaEnvMapper extends MyBatisBaseDao<OperaEnv, Integer> {
    List<OperaEnv> query(OperaEnv obj);
}