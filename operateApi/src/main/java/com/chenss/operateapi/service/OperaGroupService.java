package com.chenss.operateapi.service;

import cn.hutool.core.util.IdUtil;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.mapper.OperaGroupDetailMapper;
import com.chenss.operateapi.mapper.OperaGroupMapper;
import com.chenss.operateapi.model.OperaGroup;
import com.chenss.operateapi.model.OperaGroupAndDetailParam;
import com.chenss.operateapi.model.OperaGroupDetail;
import com.chenss.operateapi.model.OperaGroupHostDo;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.response.GroupHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class OperaGroupService {
    @Autowired
    private OperaGroupMapper operaGroupMapper;
    @Autowired
    private OperaGroupDetailMapper operaGroupDetailMapper;

    public ServiceResultDTO<List<OperaGroup>> query(OperaGroup operaLabel) {
        return new ServiceResultDTO<>(operaGroupMapper.query(operaLabel));
    }

    public ServiceResultDTO<OperaGroup> selectByPrimaryKey(String id) {
        return new ServiceResultDTO<>(operaGroupMapper.selectByPrimaryKey(id));
    }

    public ServiceResultDTO<Integer> insert(OperaGroupAndDetailParam param) {
        OperaGroup operaGroup = new OperaGroup();
        if (StringUtils.isNullOrEmpty(param.getId())) {
            operaGroup.setGroupName(param.getGroupName());
            List<OperaGroup> operaGroups = operaGroupMapper.query(operaGroup);
            if (null != operaGroups && operaGroups.size() > 0) {
                return new ServiceResultDTO().fail("分组名称已经存在，无法插入");
            }

            operaGroup.setId(IdUtil.simpleUUID());

            List<String> hostIds = validateDetailExists(param,param.getId());
            if (null != hostIds && hostIds.size()>0) {
                return new ServiceResultDTO().fail(String.format("主机已经分组，无法重复分组，具体ID为：[%s]",hostIds));
            }

            operaGroup.setGroupType(param.getGroupType());
            operaGroup.setGroupRemark(param.getGroupRemark());
            int insertResult = operaGroupMapper.insertSelective(operaGroup);
            List<OperaGroupDetail> details = new ArrayList<>();
            for (String hostId: param.getHostIds()) {
                OperaGroupDetail detailItem = new OperaGroupDetail();
                detailItem.setId(IdUtil.simpleUUID());
                detailItem.setGroupId(operaGroup.getId());
                detailItem.setItemId(hostId);
                details.add(detailItem);
            }
            operaGroupDetailMapper.insertBatch(details);
            return new ServiceResultDTO().ok(insertResult);
        }
        OperaGroup opera = operaGroupMapper.selectByPrimaryKey(param.getId());
        if (null == opera) {
            return new ServiceResultDTO().fail("对象不存在无法修改");
        }
        param.setGroupName(param.getGroupName());
        List<OperaGroup> operaItems = operaGroupMapper.query(param);
        if (null != operaItems && operaItems.size() > 0) {
            if (!operaItems.get(0).getId().equals(param.getId())) {
                return new ServiceResultDTO().fail("分组名称已经存在，无法修改");
            }
        }
        opera.setGroupType(param.getGroupType());
        opera.setGroupName(param.getGroupName());
        opera.setGroupRemark(param.getGroupRemark());
        int updateResult = operaGroupMapper.updateByPrimaryKeySelective(opera);
        return new ServiceResultDTO().ok(updateResult);
    }
    public ServiceResultDTO<Integer> addDetail(OperaGroupAndDetailParam param) {
        if (StringUtils.isNullOrEmpty(param.getId())) {
            return new ServiceResultDTO().fail("没有分组，无法增加主机");
        }
        OperaGroup opera = operaGroupMapper.selectByPrimaryKey(param.getId());
        if (null == opera) {
            return new ServiceResultDTO().fail("没有分组，无法增加主机");
        }
        List<String> hostIds = validateDetailExists(param,param.getId());
        if (null != hostIds && hostIds.size()>0) {
            return new ServiceResultDTO().fail(String.format("主机已经分组，无法重复分组，具体ID为：[%s]",hostIds));
        }
        hostIds = validateDetailExists(param,null);

        List<OperaGroupDetail> details = new ArrayList<>();
        for (String hostId: param.getHostIds()) {
            if (null!=hostIds && hostIds.contains(hostId)) {
                continue;
            }
            OperaGroupDetail detailItem = new OperaGroupDetail();
            detailItem.setId(IdUtil.simpleUUID());
            detailItem.setGroupId(opera.getId());
            detailItem.setItemId(hostId);
            details.add(detailItem);
        }
        int addResult = operaGroupDetailMapper.insertBatch(details);
        return new ServiceResultDTO().ok(addResult);
    }

    private List<String> validateDetailExists(OperaGroupAndDetailParam param, String groupId) {
        OperaGroupDetail detailParam = new OperaGroupDetail();
        detailParam.setId(groupId);
        detailParam.setHostIds(param.getHostIds());
        List<OperaGroupDetail> detailList = operaGroupDetailMapper.query(detailParam);
        if (null !=detailList &&detailList.size()>0) {
            List<String> hostIds = detailList.stream().map(OperaGroupDetail::getItemId).collect(Collectors.toList());
            return hostIds;
        }
        return null;
    }

    public ServiceResultDTO<Integer> delete(String id) {
        OperaGroup opera = operaGroupMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new ServiceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        operaGroupDetailMapper.deleteByGroupId(id);
        int updateResult = operaGroupMapper.deleteByPrimaryKey(id);
        return new ServiceResultDTO<Integer>().ok(updateResult);
    }

    public PaginationQueryResult<GroupHostResponse> pageQuery(GroupHostParam param) {
        PaginationQueryResult<GroupHostResponse> result = new PaginationQueryResult<GroupHostResponse>();
        int totalSize = operaGroupMapper.countQueryHosts(param);
        if (totalSize>0) {
            List<OperaGroupHostDo> operaHostList = operaGroupMapper.pageQueryHosts(param);
            List<GroupHostResponse> pageList = new ArrayList<>();
            for (OperaGroupHostDo groupHostDo:
                 operaHostList) {
                pageList.add(new GroupHostResponse(groupHostDo));
            }
            result.setResultList(pageList);
        }
        result.setTotalSize(totalSize);
        return result;
    }
}
