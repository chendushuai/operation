package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaAppNetwork;
import org.springframework.stereotype.Repository;

/**
 * OperaAppNetworkMapper继承基类
 */
@Repository
public interface OperaAppNetworkMapper extends MyBatisBaseDao<OperaAppNetwork, String> {
}