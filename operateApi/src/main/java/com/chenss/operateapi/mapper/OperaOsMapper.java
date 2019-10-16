package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaOs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaOsMapper继承基类
 */
@Mapper
public interface OperaOsMapper extends MyBatisBaseDao<OperaOs, Integer> {
    List<OperaOs> query(OperaOs obj);
}