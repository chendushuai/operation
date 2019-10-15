package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaHost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * OperaHostMapper继承基类
 */
@Mapper
public interface OperaHostMapper extends MyBatisBaseDao<OperaHost, String> {
    List<OperaHost> query(OperaHost obj);
}