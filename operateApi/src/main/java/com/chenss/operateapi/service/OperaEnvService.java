package com.chenss.operateapi.service;

import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.mapper.OperaEnvMapper;
import com.chenss.operateapi.model.OperaEnv;
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
        OperaEnv param = new OperaEnv();
        if (operaEnv.getId()!=null) {
            param.setId(operaEnv.getId());
        }
        if (!StringUtils.isNullOrEmpty(operaEnv.getEnvType())) {
            param.setEnvType(operaEnv.getEnvType());
        }
        if (!StringUtils.isNullOrEmpty(operaEnv.getEnvName())) {
            param.setEnvName(operaEnv.getEnvName());
        }
        if (!StringUtils.isNullOrEmpty(operaEnv.getApolloEnv())) {
            param.setApolloEnv(operaEnv.getApolloEnv());
        }
        if (!StringUtils.isNullOrEmpty(operaEnv.getEnvDesc())) {
            param.setEnvDesc(operaEnv.getEnvDesc());
        }
        return new SeviceResultDTO<>(true, operaEnvMapper.query(param));
    }

    public SeviceResultDTO<OperaEnv> selectByPrimaryKey(int id) {
        return new SeviceResultDTO<>(true, operaEnvMapper.selectByPrimaryKey(id));
    }

    public SeviceResultDTO<Integer> insertOrUpdate(OperaEnv obj) {
        OperaEnv param = new OperaEnv();
        if (obj.getId() == null) {
            param.setEnvType(obj.getEnvType());
            List<OperaEnv> operaEnvs = operaEnvMapper.query(param);
            if (null != operaEnvs && operaEnvs.size() > 0) {
                return new SeviceResultDTO<Integer>().fail("环境类型已经存在，无法插入");
            }

            int insertResult = operaEnvMapper.insertSelective(obj);
            return new SeviceResultDTO<Integer>().ok(insertResult);
        }
        OperaEnv opera = operaEnvMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        param.setEnvType(obj.getEnvType());
        List<OperaEnv> operaEnvs = operaEnvMapper.query(param);
        if (null != operaEnvs && operaEnvs.size() > 0) {
            if (!operaEnvs.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<Integer>().fail("环境类型已经存在，无法修改");
            }
        }
        int updateResult = operaEnvMapper.updateByPrimaryKeySelective(obj);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public SeviceResultDTO<Integer> delete(int id) {
        OperaEnv opera = operaEnvMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaEnvMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }
}
