package com.chenss.operateapi.service;

import cn.hutool.core.util.IdUtil;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.mapper.OperaApplicationMapper;
import com.chenss.operateapi.mapper.OperaGroupDetailMapper;
import com.chenss.operateapi.mapper.OperaGroupMapper;
import com.chenss.operateapi.model.*;
import com.chenss.operateapi.param.GroupApplicationParam;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.param.OperaGroupDetailParam;
import com.chenss.operateapi.response.ApplicationResponse;
import com.chenss.operateapi.response.EnvHostDO;
import com.chenss.operateapi.response.GroupHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 服务器分组服务
 * @author chenss002
 * @date 2019-10-23 11:22:01
 */
@Service
public class OperaApplicationService {
    @Autowired
    private OperaApplicationMapper operaApplicationMapper;

    public ServiceResultDTO<List<OperaApplication>> query(OperaApplication operaApplication) {
        return new ServiceResultDTO<>(operaApplicationMapper.query(operaApplication));
    }

    public ServiceResultDTO<OperaApplication> selectByPrimaryKey(String id) {
        return new ServiceResultDTO<>(operaApplicationMapper.selectByPrimaryKey(id));
    }

    public ServiceResultDTO<Integer> insertOrUpdate(OperaApplication obj) {
        if (StringUtils.isNullOrEmpty(obj.getId())) {
            String checkExistResult = checkExists(obj, null);
            if (null != checkExistResult) {
                return new ServiceResultDTO<Integer>().fail(checkExistResult);
            }
            obj.setId(IdUtil.simpleUUID());
            int insertResult = operaApplicationMapper.insertSelective(obj);
            return new ServiceResultDTO<Integer>().ok(insertResult);
        }
        String checkExistResult = checkExists(null, obj.getId());
        if (null != checkExistResult) {
            return new ServiceResultDTO<Integer>().fail(checkExistResult);
        }
        checkExistResult = checkExists(obj, obj.getId());
        if (null != checkExistResult) {
            return new ServiceResultDTO<Integer>().fail(checkExistResult);
        }
        int updateResult = operaApplicationMapper.updateByPrimaryKeySelective(obj);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }

    private String checkExists(OperaApplication obj,String id) {
        if (null==obj && null != id) {
            OperaApplication opera = operaApplicationMapper.selectByPrimaryKey(obj.getId());
            if (null == opera) {
                return "对象不存在无法修改";
            }
            return null;
        }
        OperaApplication param = new OperaApplication();
        param.setAppName(obj.getAppName());
        List<OperaApplication> operaApplications = operaApplicationMapper.query(param);
        if (null != operaApplications && operaApplications.size() > 0) {
            if (null == id || !id.equals(operaApplications.get(0).getId())) {
                return "指定应用名称已经存在，无法插入";
            }
        }
        param.setAppCmdbId(obj.getAppCmdbId());
        operaApplications = operaApplicationMapper.query(param);
        if (null != operaApplications && operaApplications.size() > 0) {
            if (null == id || !id.equals(operaApplications.get(0).getId())) {
                return "指定应用CMDB_ID已经存在，无法插入";
            }
        }
        return null;
    }

    public ServiceResultDTO<Integer> delete(String id) {
        String checkExistResult = checkExists(null, id);
        if (null != checkExistResult) {
            return new ServiceResultDTO<Integer>().fail(checkExistResult);
        }
        int updateResult = operaApplicationMapper.deleteByPrimaryKey(id);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }

    public PaginationQueryResult<ApplicationResponse> pageQuery(GroupApplicationParam param) {
        PaginationQueryResult<ApplicationResponse> result = new PaginationQueryResult<>();
        int totalSize = operaApplicationMapper.countListPaging(param);
        if (totalSize>0) {
            List<OperaApplication> operaApplicationList = operaApplicationMapper.listPaging(param);
            List<ApplicationResponse> pageList = new ArrayList<>();
            for (OperaApplication groupHostDo:
                    operaApplicationList) {
                pageList.add(new ApplicationResponse(groupHostDo));
            }
            result.setResultList(pageList);
        }
        result.setTotalSize(totalSize);
        return result;
    }
}
