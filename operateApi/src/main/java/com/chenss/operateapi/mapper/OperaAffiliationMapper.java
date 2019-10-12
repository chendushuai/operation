package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaAffiliation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaAffiliationMapper继承基类
 */
@Repository
public interface OperaAffiliationMapper extends MyBatisBaseDao<OperaAffiliation, Integer> {
    List<OperaAffiliation> query(OperaAffiliation obj);
}