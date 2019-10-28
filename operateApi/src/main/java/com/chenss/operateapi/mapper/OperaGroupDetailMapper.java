package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaGroupDetail;
import com.chenss.operateapi.param.OperaGroupDetailParam;
import com.chenss.operateapi.response.EnvHostDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OperaGroupDetailMapper继承基类
 * @author chenss002
 * @date 2019-10-23 12:19:59
 */
@Mapper
public interface OperaGroupDetailMapper extends MyBatisBaseDao<OperaGroupDetail, String> {
    List<OperaGroupDetail> query(OperaGroupDetailParam obj);
    List<OperaGroupDetail> verify(OperaGroupDetailParam obj);
    int insertBatch(List<OperaGroupDetail> groupDetailList);

    int deleteByGroupId(String id);

    List<EnvHostDO> queryGroupHostId(String id);
}