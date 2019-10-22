package com.chenss.operateapi.service;

import cn.hutool.core.util.IdUtil;
import com.chenss.operateapi.common.GuidUtils;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.mapper.OperaEnvMapper;
import com.chenss.operateapi.mapper.OperaLabelMapper;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.model.OperaLabel;
import com.chenss.operateapi.param.OperaLabelPageParam;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 键值对操作服务
 * @author chenss002
 * @date 2019-10-22 12:49:28
 */
@Service
public class OperaLabelService {
    @Autowired
    private OperaLabelMapper operaLabelMapper;

    public SeviceResultDTO<List<OperaLabel>> query(OperaLabel operaLabel) {
        return new SeviceResultDTO<>(operaLabelMapper.query(operaLabel));
    }

    public SeviceResultDTO<OperaLabel> selectByPrimaryKey(String id) {
        return new SeviceResultDTO<>(operaLabelMapper.selectByPrimaryKey(id));
    }

    public SeviceResultDTO<Integer> insertOrUpdate(OperaLabel obj) {
        OperaLabel param = new OperaLabel();
        if (StringUtils.isNullOrEmpty(obj.getId())) {
            param.setLabelGroup(obj.getLabelGroup());
            param.setLabelKey(obj.getLabelKey());
            List<OperaLabel> operaEnvs = operaLabelMapper.query(param);
            if (null != operaEnvs && operaEnvs.size() > 0) {
                return new SeviceResultDTO<Integer>().fail("指定键值已经存在，无法插入");
            }
            obj.setId(IdUtil.simpleUUID());
            int insertResult = operaLabelMapper.insertSelective(obj);
            return new SeviceResultDTO<Integer>().ok(insertResult);
        }
        OperaLabel opera = operaLabelMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        param.setLabelGroup(obj.getLabelGroup());
        param.setLabelKey(obj.getLabelKey());
        List<OperaLabel> operaItems = operaLabelMapper.query(param);
        if (null != operaItems && operaItems.size() > 0) {
            if (!operaItems.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<Integer>().fail("指定键值已经存在，无法修改");
            }
        }
        int updateResult = operaLabelMapper.updateByPrimaryKeySelective(obj);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public SeviceResultDTO<Integer> delete(String id) {
        OperaLabel opera = operaLabelMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaLabelMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public PaginationQueryResult<OperaLabel> pageQuery(OperaLabelPageParam param) {
        PaginationQueryResult<OperaLabel> result = new PaginationQueryResult<OperaLabel>();
        int totalSize = operaLabelMapper.countListPaging(param);
        if (totalSize>0) {
            List<OperaLabel> operaHostList = operaLabelMapper.listPaging(param);
            result.setResultList(operaHostList);
        }
        result.setTotalSize(totalSize);
        return result;
    }
}
