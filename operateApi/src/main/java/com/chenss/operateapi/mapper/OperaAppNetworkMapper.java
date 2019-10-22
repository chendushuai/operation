package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaAppNetwork;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaAppNetworkMapper继承基类
 */
@Mapper
public interface OperaAppNetworkMapper extends MyBatisBaseDao<OperaAppNetwork, String> {
    List<OperaAppNetwork> query(OperaAppNetwork obj);
}