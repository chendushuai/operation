package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaApplication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaApplicationMapper继承基类
 */
@Mapper
public interface OperaApplicationMapper extends MyBatisBaseDao<OperaApplication, String> {
    List<OperaApplication> query(OperaApplication obj);
}