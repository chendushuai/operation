package com.chenss.operateapi.service;

import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.mapper.OperaOsMapper;
import com.chenss.operateapi.model.OperaOs;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenss002
 */
@Service
public class OperaOsService {
    @Autowired
    private OperaOsMapper operaOsMapper;

    public SeviceResultDTO<List<OperaOs>> getOs(OperaOs operaOs) {
        OperaOs param = new OperaOs();
        if (operaOs.getId()!=null) {
            param.setId(operaOs.getId());
        }
        if (!StringUtils.isNullOrEmpty(operaOs.getOsName())) {
            param.setOsName(operaOs.getOsName());
        }
        if (!StringUtils.isNullOrEmpty(operaOs.getOsVersion())) {
            param.setOsVersion(operaOs.getOsVersion());
        }
        return new SeviceResultDTO<>(true, operaOsMapper.query(param));
    }

    public SeviceResultDTO<OperaOs> selectByPrimaryKey(int id) {
        return new SeviceResultDTO<>(true, operaOsMapper.selectByPrimaryKey(id));
    }

    public SeviceResultDTO<Integer> insertOrUpdate(OperaOs obj) {
        OperaOs param = new OperaOs();
        param.setOsName(obj.getOsName());
        param.setOsVersion(obj.getOsVersion());
        List<OperaOs> operaOsList= operaOsMapper.query(param);
        if (null != operaOsList && operaOsList.size() > 0) {
            if (obj.getId() == null || !operaOsList.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<Integer>().fail("服务器主机名称已经存在，无法插入");
            }
        }
        param.setOsRemark(obj.getOsRemark());
        if (obj.getId() == null) {
            int insertResult = operaOsMapper.insertSelective(param);
            return new SeviceResultDTO<Integer>().ok(insertResult);
        }
        param.setId(obj.getId());
        OperaOs opera = operaOsMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        int updateResult = operaOsMapper.updateByPrimaryKeySelective(param);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public SeviceResultDTO<Integer> delete(int id) {
        OperaOs opera = operaOsMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaOsMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }
}
