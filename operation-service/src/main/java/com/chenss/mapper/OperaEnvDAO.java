package com.chenss.mapper;

import com.chenss.model.OperaEnv;
import org.springframework.stereotype.Repository;

/**
 * OperaEnvDAO继承基类
 */
@Repository
public interface OperaEnvDAO extends MyBatisBaseDao<OperaEnv, Integer> {
}