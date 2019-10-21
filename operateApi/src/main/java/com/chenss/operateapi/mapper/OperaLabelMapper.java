package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaLabel;
import org.springframework.stereotype.Repository;

/**
 * OperaLabelMapper继承基类
 */
@Repository
public interface OperaLabelMapper extends MyBatisBaseDao<OperaLabel, String> {
}