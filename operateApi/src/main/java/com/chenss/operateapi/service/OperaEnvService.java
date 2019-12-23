package com.chenss.operateapi.service;

import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.mapper.OperaEnvMapper;
import com.chenss.operateapi.model.OperaEnv;
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

    public ServiceResultDTO<List<OperaEnv>> getEnv(OperaEnv operaEnv) {
        return new ServiceResultDTO<>(true, operaEnvMapper.query(operaEnv));
    }

    public ServiceResultDTO<OperaEnv> selectByPrimaryKey(int id) {
        return new ServiceResultDTO<>(true, operaEnvMapper.selectByPrimaryKey(id));
    }

    public ServiceResultDTO<Integer> insertOrUpdate(OperaEnv obj) {
        OperaEnv param = new OperaEnv();
        if (obj.getId() == null) {
            param.setEnvType(obj.getEnvType());
            List<OperaEnv> operaEnvs = operaEnvMapper.query(param);
            if (null != operaEnvs && operaEnvs.size() > 0) {
                return new ServiceResultDTO<Integer>().fail("环境类型已经存在，无法插入");
            }

            int insertResult = operaEnvMapper.insertSelective(obj);
            return new ServiceResultDTO<Integer>().ok(insertResult);
        }
        OperaEnv opera = operaEnvMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new ServiceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        param.setEnvType(obj.getEnvType());
        List<OperaEnv> operaEnvs = operaEnvMapper.query(param);
        if (null != operaEnvs && operaEnvs.size() > 0) {
            if (!operaEnvs.get(0).getId().equals(obj.getId())) {
                return new ServiceResultDTO<Integer>().fail("环境类型已经存在，无法修改");
            }
        }
        int updateResult = operaEnvMapper.updateByPrimaryKeySelective(obj);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }

    public ServiceResultDTO<Integer> delete(int id) {
        OperaEnv opera = operaEnvMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new ServiceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaEnvMapper.deleteByPrimaryKey(id);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }
}
