package com.chenss.operateApi.service;

import com.chenss.operateApi.mapper.OperaEnvMapper;
import com.chenss.operateApi.model.OperaEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenss002
 */
@Service
public class OperaEnvService {
    @Autowired
    private OperaEnvMapper operaEnvMapper;

    public List<OperaEnv> getEnv(OperaEnv operaEnv) {
        return operaEnvMapper.query(operaEnv);
    }
}
