package com.chenss.operateApi.service;

import com.chenss.operateApi.mapper.OperaEnvMapper;
import com.chenss.operateApi.model.OperaEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenss002
 */
@Service
public class OperaEnvService {
    @Autowired
    private OperaEnvMapper operaEnvMapper;

    public OperaEnv getEnv() {
        return operaEnvMapper.selectByPrimaryKey(1);
    }
}
