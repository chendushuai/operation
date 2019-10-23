package com.chenss.operateapi;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaGroup;
import com.chenss.operateapi.model.OperaGroupAndDetailParam;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.param.OperaHostParam;
import com.chenss.operateapi.response.GroupHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaGroupService;
import com.chenss.operateapi.service.OperaHostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperaGroupServiceTest {
    @Autowired
    private OperaGroupService operaGroupService;
    @Autowired
    private OperaHostService operaHostService;

    @Test
    public void pageQuery(){
        GroupHostParam param = new GroupHostParam();
        param.setPageIndex(0);
        PaginationQueryResult<GroupHostResponse> paginationQueryResult = operaGroupService.pageQuery(param);
        System.out.println(JSON.toJSONString(paginationQueryResult));
    }

    @Test
    public void createGroup() {
        /*OperaHostParam param = new OperaHostParam();
        param.setHostIp("172.20.193.13");
        PaginationQueryResult<OperaHost> queryResult = operaHostService.pageQuery(param);
        OperaHost operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));

        param = new OperaHostParam();
        param.setHostIp("172.20.193.14");
        queryResult = operaHostService.pageQuery(param);
        operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));

        param = new OperaHostParam();
        param.setHostIp("172.21.52.15");
        queryResult = operaHostService.pageQuery(param);
        operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));

        param = new OperaHostParam();
        param.setHostIp("172.21.52.16");
        queryResult = operaHostService.pageQuery(param);
        operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));*/

        // 172.20.193.13 : 87A613B973A3449A98B89B9AB29BFEA6
        // 172.20.193.14 : 7988BC4AB23F42368CFFE15A891F80FC
        // 172.21.52.15 : BFBF93DE0D624C34923ACC2EF87CD5B7
        // 172.21.52.16 : E61A7BB3AF7E4F68AAA81C83D2099E75

        OperaGroupAndDetailParam param = new OperaGroupAndDetailParam();
        param.setGroupType("host");
        param.setGroupName("SZ_FY_193.13_14-52.15_16");
        param.setGroupRemark("172.20.193.13-14,172.21.52.15-16");
        List<String> hostIds=new ArrayList<>();
        hostIds.add("87A613B973A3449A98B89B9AB29BFEA6");
        hostIds.add("7988BC4AB23F42368CFFE15A891F80FC");
        hostIds.add("BFBF93DE0D624C34923ACC2EF87CD5B7");
        hostIds.add("E61A7BB3AF7E4F68AAA81C83D2099E75");
        param.setHostIds(hostIds);
        ServiceResultDTO<Integer> insertResult = operaGroupService.insert(param);

        GroupHostParam pageQueryParam = new GroupHostParam();
        pageQueryParam.setGroupName("SZ_FY_193.13_14-52.15_16");
        PaginationQueryResult<GroupHostResponse> groupHostPageQueryResult = operaGroupService.pageQuery(pageQueryParam);
        System.out.println(JSON.toJSONString(groupHostPageQueryResult));
    }

    @Test
    public void updateGroup() {
        /*OperaHostParam param = new OperaHostParam();
        param.setHostIp("172.20.193.13");
        PaginationQueryResult<OperaHost> queryResult = operaHostService.pageQuery(param);
        OperaHost operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));

        param = new OperaHostParam();
        param.setHostIp("172.20.193.14");
        queryResult = operaHostService.pageQuery(param);
        operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));

        param = new OperaHostParam();
        param.setHostIp("172.21.52.15");
        queryResult = operaHostService.pageQuery(param);
        operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));

        param = new OperaHostParam();
        param.setHostIp("172.21.52.16");
        queryResult = operaHostService.pageQuery(param);
        operaHost = queryResult.getResultList().get(0);
        System.out.println(String.format("// %s : %s",operaHost.getHostIp(),operaHost.getId()));*/
        GroupHostParam pageQueryParam = new GroupHostParam();
        pageQueryParam.setGroupName("SZ_FY_193.13_14-52.15_16");
        PaginationQueryResult<GroupHostResponse> groupHostPageQueryResult = operaGroupService.pageQuery(pageQueryParam);
        System.out.println(JSON.toJSONString(groupHostPageQueryResult));

        ServiceResultDTO<OperaGroup> operaGroupServiceResultDTO = operaGroupService.selectByPrimaryKey(groupHostPageQueryResult.getResultList().get(0).getId());
        OperaGroup operaGroup = operaGroupServiceResultDTO.getObject();
        OperaGroupAndDetailParam param = new OperaGroupAndDetailParam();
        param.setId(operaGroup.getId());
        param.setGroupRemark(operaGroup.getGroupRemark()+"  修改Remark");
        ServiceResultDTO<Integer> insertResult = operaGroupService.insert(param);
        System.out.println(JSON.toJSONString(insertResult));
    }

    @Test
    public void query() {
        GroupHostParam pageQueryParam = new GroupHostParam();
        pageQueryParam.setGroupName("SZ_FY_193.11_12-52.13_14");
        PaginationQueryResult<GroupHostResponse> groupHostPageQueryResult = operaGroupService.pageQuery(pageQueryParam);
        System.out.println(JSON.toJSONString(groupHostPageQueryResult));
    }
    @Test
    public void delete() {
        OperaGroup pageQueryParam = new OperaGroup();
        pageQueryParam.setGroupName("SZ_FY_193.13_14-52.15_16");
        ServiceResultDTO<List<OperaGroup>> query = operaGroupService.query(pageQueryParam);
        System.out.println(JSON.toJSONString(query));
        if (query.getObject().size()>0) {
            ServiceResultDTO<Integer> deleteResult = operaGroupService.delete(query.getObject().get(0).getId());
            System.out.println(deleteResult);
        }
    }
}
