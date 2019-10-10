package com.chenss.operateApi.service;

import com.chenss.operateApi.common.SeviceResultDTO;
import com.chenss.operateApi.mapper.OperaEnvMapper;
import com.chenss.operateApi.model.OperaEnv;
import com.mysql.cj.util.StringUtils;
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

    public SeviceResultDTO<List<OperaEnv>> getEnv(OperaEnv operaEnv) {
        return new SeviceResultDTO<>(true,operaEnvMapper.query(operaEnv)) ;
    }
    public SeviceResultDTO<OperaEnv> selectByPrimaryKey(int id) {
        return new SeviceResultDTO<>(true,operaEnvMapper.selectByPrimaryKey(id)) ;
    }
    public SeviceResultDTO<Integer> update(OperaEnv obj) {
        OperaEnv opera = operaEnvMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        int updateResult=operaEnvMapper.updateByPrimaryKeySelective(obj);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }
    public SeviceResultDTO<Integer> delete(int id) {
        OperaEnv opera = operaEnvMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult=operaEnvMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }
}
