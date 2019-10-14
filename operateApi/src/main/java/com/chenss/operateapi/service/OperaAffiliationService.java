package com.chenss.operateapi.service;

import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.mapper.OperaAffiliationMapper;
import com.chenss.operateapi.model.OperaAffiliation;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chenss002
 */
@Service
public class OperaAffiliationService {
    @Autowired
    private OperaAffiliationMapper operaAffiliationMapper;

    public SeviceResultDTO<List<OperaAffiliation>> listAll(OperaAffiliation operaAffiliation) {
        OperaAffiliation param = new OperaAffiliation();
        if (operaAffiliation.getId()!=null) {
            param.setId(operaAffiliation.getId());
        }
        if (!StringUtils.isNullOrEmpty(operaAffiliation.getName())) {
            param.setName(operaAffiliation.getName());
        }
        if (!StringUtils.isNullOrEmpty(operaAffiliation.getCreateTimeBegin())) {
            param.setCreateTimeBegin(operaAffiliation.getCreateTimeBegin());
        }
        if (!StringUtils.isNullOrEmpty(operaAffiliation.getCreateTimeEnd())) {
            param.setCreateTimeEnd(operaAffiliation.getCreateTimeEnd());
        }
        if (!StringUtils.isNullOrEmpty(operaAffiliation.getModifyTimeBegin())) {
            param.setModifyTimeBegin(operaAffiliation.getModifyTimeBegin());
        }
        if (!StringUtils.isNullOrEmpty(operaAffiliation.getModifyTimeEnd())) {
            param.setModifyTimeEnd(operaAffiliation.getModifyTimeEnd());
        }
        return new SeviceResultDTO<>(true, operaAffiliationMapper.query(param));
    }

    public SeviceResultDTO<OperaAffiliation> selectByPrimaryKey(int id) {
        return new SeviceResultDTO<>(true, operaAffiliationMapper.selectByPrimaryKey(id));
    }

    public SeviceResultDTO<Integer> insertOrUpdate(OperaAffiliation obj) {
        OperaAffiliation param = new OperaAffiliation();
        if (obj.getId() == null) {
            param.setName(obj.getName());
            List<OperaAffiliation> operaAffiliations = operaAffiliationMapper.query(param);
            if (null != operaAffiliations && operaAffiliations.size() > 0) {
                return new SeviceResultDTO<Integer>().fail("归属类型已经存在，无法插入");
            }
            param.setDesc(obj.getDesc());

            int insertResult = operaAffiliationMapper.insertSelective(param);
            return new SeviceResultDTO<Integer>().ok(insertResult);
        }
        OperaAffiliation opera = operaAffiliationMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        param.setId(obj.getId());
        param.setName(obj.getName());
        List<OperaAffiliation> operaAffiliations = operaAffiliationMapper.query(param);
        if (null != operaAffiliations && operaAffiliations.size() > 0) {
            if (!operaAffiliations.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<Integer>().fail("归属类型已经存在，无法修改");
            }
        }
        param.setDesc(obj.getDesc());
        int updateResult = operaAffiliationMapper.updateByPrimaryKeySelective(param);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public SeviceResultDTO<Integer> delete(int id) {
        OperaAffiliation opera = operaAffiliationMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaAffiliationMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }
}
