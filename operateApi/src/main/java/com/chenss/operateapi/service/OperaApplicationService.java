package com.chenss.operateapi.service;

import cn.hutool.core.util.IdUtil;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.mapper.OperaApplicationGroupMapper;
import com.chenss.operateapi.mapper.OperaApplicationMapper;
import com.chenss.operateapi.model.*;
import com.chenss.operateapi.param.GroupApplicationParam;
import com.chenss.operateapi.request.OperaApplicationGroupDO;
import com.chenss.operateapi.response.ApplicationGroupEnvHostDo;
import com.chenss.operateapi.response.ApplicationResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务器分组服务
 * @author chenss002
 * @date 2019-10-23 11:22:01
 */
@Service
public class OperaApplicationService {
    @Autowired
    private OperaApplicationMapper operaApplicationMapper;

    @Autowired
    private OperaApplicationGroupMapper operaApplicationGroupMapper;
    @Autowired
    private OperaGroupService operaGroupService;

    public ServiceResultDTO<List<OperaApplication>> query(OperaApplication operaApplication) {
        return new ServiceResultDTO<>(operaApplicationMapper.query(operaApplication));
    }

    public ServiceResultDTO<OperaApplication> selectByPrimaryKey(String id) {
        return new ServiceResultDTO<>(operaApplicationMapper.selectByPrimaryKey(id));
    }

    public ServiceResultDTO<List<ApplicationGroupEnvHostDo>> listGroupHostInfo(String id) {
        return new ServiceResultDTO<>(operaApplicationMapper.listGroupHostInfo(id));
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
        String checkExistResult = checkExists(obj.getId());
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
    private String checkExists(String id) {
        return checkExists(null,id);
    }

    private String checkExists(OperaApplication obj,String id) {
        if (null==obj && null != id) {
            OperaApplication opera = operaApplicationMapper.selectByPrimaryKey(id);
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

    public ServiceResultDTO<Integer> insertOrUpdateApplicationGroup(OperaApplicationGroup obj) {
        ServiceResultDTO<OperaGroup> operaGroupServiceResultDTO = operaGroupService.selectByPrimaryKey(obj.getGroupId());
        if (operaGroupServiceResultDTO==null || !operaGroupServiceResultDTO.isSuccess() || operaGroupServiceResultDTO.getObject() == null) {
            return new ServiceResultDTO<Integer>().fail("分组不存在");
        }
        if (!StringUtils.isNullOrEmpty(checkExists(obj.getAppId()))) {
            return new ServiceResultDTO<Integer>().fail("应用不存在");
        }
        List<OperaApplicationGroup> operaApplicationGroups = operaApplicationGroupMapper.selectByAppIdAndGroupId(obj);
        boolean blnExists = operaApplicationGroups != null && operaApplicationGroups.size() >= 1 && operaApplicationGroups.get(0) != null;
        if (StringUtils.isNullOrEmpty(obj.getId())) {
            if (blnExists) {
                return new ServiceResultDTO<Integer>().fail("应用和分组关系已绑定");
            }
            obj.setId(IdUtil.simpleUUID());
            int insertResult = operaApplicationGroupMapper.insertSelective(obj);
            return new ServiceResultDTO<Integer>().ok(insertResult);
        }
        boolean blnExists2 = blnExists && operaApplicationGroups.get(0).getId().equals(obj.getId());
        if (blnExists2) {
            return new ServiceResultDTO<Integer>().fail("应用和分组关系已绑定");
        }
        int updateResult = operaApplicationGroupMapper.updateByPrimaryKeySelective(obj);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }

    public ServiceResultDTO<Integer> deleteApplicationGroup(String id) {
        OperaApplicationGroup operaApplicationGroup = operaApplicationGroupMapper.selectByPrimaryKey(id);
        if (null == operaApplicationGroup) {
            return new ServiceResultDTO<Integer>().fail("应用分组部署关系不存在");
        }
        int updateResult = operaApplicationGroupMapper.deleteByPrimaryKey(id);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }
}
