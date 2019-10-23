package com.chenss.operateapi.service;

import cn.hutool.core.lang.func.VoidFunc0;
import cn.hutool.core.util.IdUtil;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.mapper.OperaGroupDetailMapper;
import com.chenss.operateapi.mapper.OperaGroupMapper;
import com.chenss.operateapi.model.OperaGroup;
import com.chenss.operateapi.model.OperaGroupDetail;
import com.chenss.operateapi.model.OperaGroupHostDo;
import com.chenss.operateapi.model.OperaLabel;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.param.OperaLabelPageParam;
import com.chenss.operateapi.response.GroupHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.mysql.cj.util.StringUtils;
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
public class OperaGroupService {
    @Autowired
    private OperaGroupMapper operaGroupMapper;
    @Autowired
    private OperaGroupDetailMapper operaGroupDetailMapper;

    public SeviceResultDTO<List<OperaGroup>> query(OperaGroup operaLabel) {
        return new SeviceResultDTO<>(operaGroupMapper.query(operaLabel));
    }

    public SeviceResultDTO<OperaGroup> selectByPrimaryKey(String id) {
        return new SeviceResultDTO<>(operaGroupMapper.selectByPrimaryKey(id));
    }

    public SeviceResultDTO<String> insertOrUpdate(OperaGroup obj) {
        OperaGroup param = new OperaGroup();
        if (StringUtils.isNullOrEmpty(obj.getId())) {
            param.setGroupName(obj.getGroupName());
            List<OperaGroup> operaGroups = operaGroupMapper.query(param);
            if (null != operaGroups && operaGroups.size() > 0) {
                return new SeviceResultDTO<String>().fail("分组名称已经存在，无法插入");
            }
            obj.setId(IdUtil.simpleUUID());
            int insertResult = operaGroupMapper.insertSelective(obj);
            return new SeviceResultDTO<String>().ok(obj.getId());
        }
        OperaGroup opera = operaGroupMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<String>().fail("对象不存在无法修改");
        }
        param.setGroupName(obj.getGroupName());
        List<OperaGroup> operaItems = operaGroupMapper.query(param);
        if (null != operaItems && operaItems.size() > 0) {
            if (!operaItems.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<String>().fail("分组名称已经存在，无法修改");
            }
        }
        int updateResult = operaGroupMapper.updateByPrimaryKeySelective(obj);
        return new SeviceResultDTO<String>().ok(obj.getId());
    }

    public SeviceResultDTO<Integer> delete(String id) {
        OperaGroup opera = operaGroupMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        operaGroupDetailMapper.deleteByGroupId(id);
        int updateResult = operaGroupMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
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
