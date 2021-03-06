package com.chenss.operateapi.service;

import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.mapper.OperaServiceTypeMapper;
import com.chenss.operateapi.model.OperaServiceType;
import com.chenss.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenss002
 */
@Service
public class OperaServiceTypeService {
    @Autowired
    private OperaServiceTypeMapper operaServiceTypeMapper;

    public ServiceResultDTO<List<OperaServiceType>> listAll(OperaServiceType operaServiceType) {
        OperaServiceType param = new OperaServiceType();
        if (operaServiceType.getId()!=null) {
            param.setId(operaServiceType.getId());
        }
        if (!StringUtils.isNullOrEmpty(operaServiceType.getServiceType())) {
            param.setServiceType(operaServiceType.getServiceType());
        }
        if (!StringUtils.isNullOrEmpty(operaServiceType.getServiceName())) {
            param.setServiceName(operaServiceType.getServiceName());
        }
        if (!StringUtils.isNullOrEmpty(operaServiceType.getCreateTimeBegin())) {
            param.setCreateTimeBegin(operaServiceType.getCreateTimeBegin());
        }
        if (!StringUtils.isNullOrEmpty(operaServiceType.getCreateTimeEnd())) {
            param.setCreateTimeEnd(operaServiceType.getCreateTimeEnd());
        }
        if (!StringUtils.isNullOrEmpty(operaServiceType.getModifyTimeBegin())) {
            param.setModifyTimeBegin(operaServiceType.getModifyTimeBegin());
        }
        if (!StringUtils.isNullOrEmpty(operaServiceType.getModifyTimeEnd())) {
            param.setModifyTimeEnd(operaServiceType.getModifyTimeEnd());
        }
        return new ServiceResultDTO<>(true, operaServiceTypeMapper.query(param));
    }

    public ServiceResultDTO<OperaServiceType> selectByPrimaryKey(int id) {
        return new ServiceResultDTO<>(true, operaServiceTypeMapper.selectByPrimaryKey(id));
    }

    public ServiceResultDTO<Integer> insertOrUpdate(OperaServiceType obj) {
        OperaServiceType param = new OperaServiceType();
        if (obj.getId() == null) {
            param.setServiceType(obj.getServiceType());
            List<OperaServiceType> operaServiceTypes = operaServiceTypeMapper.query(param);
            if (null != operaServiceTypes && operaServiceTypes.size() > 0) {
                return new ServiceResultDTO<Integer>().fail("归属类型已经存在，无法插入");
            }
            param.setServiceDesc(obj.getServiceDesc());
            param.setServiceName(obj.getServiceName());

            int insertResult = operaServiceTypeMapper.insertSelective(param);
            return new ServiceResultDTO<Integer>().ok(insertResult);
        }
        OperaServiceType opera = operaServiceTypeMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new ServiceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        param.setServiceType(obj.getServiceType());
        List<OperaServiceType> operaServiceTypes = operaServiceTypeMapper.query(param);
        if (null != operaServiceTypes && operaServiceTypes.size() > 0) {
            if (!operaServiceTypes.get(0).getId().equals(obj.getId())) {
                return new ServiceResultDTO<Integer>().fail("归属类型已经存在，无法修改");
            }
        }
        param.setId(obj.getId());
        param.setServiceDesc(obj.getServiceDesc());
        param.setServiceName(obj.getServiceName());
        int updateResult = operaServiceTypeMapper.updateByPrimaryKeySelective(param);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }

    public ServiceResultDTO<Integer> delete(int id) {
        OperaServiceType opera = operaServiceTypeMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new ServiceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaServiceTypeMapper.deleteByPrimaryKey(id);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }
}
