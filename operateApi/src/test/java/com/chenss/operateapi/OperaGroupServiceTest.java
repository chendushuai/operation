package com.chenss.operateapi;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.model.OperaGroup;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.response.GroupHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaGroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperaGroupServiceTest {
    @Autowired
    private OperaGroupService operaGroupService;

    @Test
    public void pageQuery(){
        GroupHostParam param = new GroupHostParam();
        param.setPageIndex(0);
        PaginationQueryResult<GroupHostResponse> paginationQueryResult = operaGroupService.pageQuery(param);
        System.out.println(JSON.toJSONString(paginationQueryResult));
    }

    @Test
    public void createGroup() {
        OperaGroup group = new OperaGroup();
        group.setGroupName("SZ");
    }
}
