package com.chenss.operateapi.mapper;

import com.chenss.operateapi.model.OperaApplication;
import com.chenss.operateapi.param.GroupApplicationParam;
import com.chenss.operateapi.response.ApplicationGroupEnvHostDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * OperaApplicationMapper继承基类
 */
@Mapper
public interface OperaApplicationMapper extends MyBatisBaseDao<OperaApplication, String> {
    List<OperaApplication> query(OperaApplication obj);
    List<OperaApplication> listPaging(GroupApplicationParam obj);
    int countListPaging(GroupApplicationParam obj);

    List<ApplicationGroupEnvHostDo> listGroupHostInfo(String id);
}