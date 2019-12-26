package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaApplicationGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaApplicationGroupDAO继承基类
 */
@Mapper
public interface OperaApplicationGroupMapper extends MyBatisBaseDao<OperaApplicationGroup, String> {
    List<OperaApplicationGroup> selectByAppIdAndGroupId(OperaApplicationGroup obj);
}