package com.chenss.operateapi;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaApplication;
import com.chenss.operateapi.param.GroupApplicationParam;
import com.chenss.operateapi.response.ApplicationResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperaApplicationServiceTest {
    @Autowired
    private OperaApplicationService operaApplicationService;

    @Test
    public void pageQuery(){
        GroupApplicationParam param = new GroupApplicationParam();
        param.setPageIndex(0);
        PaginationQueryResult<ApplicationResponse> paginationQueryResult = operaApplicationService.pageQuery(param);
        System.out.println(JSON.toJSONString(paginationQueryResult));
    }

    @Test
    public void selectTest() {
        ServiceResultDTO<OperaApplication> operaApplicationServiceResultDTO = operaApplicationService.selectByPrimaryKey("9e985c930af24909904d9f66b69de925");
        System.out.println(JSON.toJSONString(operaApplicationServiceResultDTO));
    }
}
