package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaGroup;
import com.chenss.operateapi.model.OperaGroupHostDo;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.response.GroupHostResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaGroupMapper继承基类
 */
@Mapper
public interface OperaGroupMapper extends MyBatisBaseDao<OperaGroup, String> {
    List<OperaGroup> query(OperaGroup obj);
    List<OperaGroupHostDo> pageQueryHosts(GroupHostParam obj);
    int countQueryHosts(GroupHostParam obj);
}