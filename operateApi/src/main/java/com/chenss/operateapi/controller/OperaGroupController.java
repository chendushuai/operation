package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaGroup;
import com.chenss.operateapi.model.OperaGroupAndDetailParam;
import com.chenss.operateapi.model.OperaGroupHostDo;
import com.chenss.operateapi.model.OperaLabel;
import com.chenss.operateapi.param.GroupHostParam;
import com.chenss.operateapi.param.OperaLabelPageParam;
import com.chenss.operateapi.request.OperaLabelDO;
import com.chenss.operateapi.response.GroupHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaGroupService;
import com.chenss.operateapi.service.OperaLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 主机分组控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/group")
public class OperaGroupController extends BaseController {
    @Autowired
    private OperaGroupService operaGroupService;
    @RequestMapping("")
    @ParamNotNull(exclude = {})
    public ResponseDTO<PaginationQueryResult<GroupHostResponse>> query(@RequestBody GroupHostParam params) {
        PaginationQueryResult<GroupHostResponse> operaResult= operaGroupService.pageQuery(params);
        return new ResponseDTO(operaResult);
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaGroup> viewObject(String id) {
        ServiceResultDTO<OperaGroup> operaItem= operaGroupService.selectByPrimaryKey(id);
        return new ResponseDTO(operaItem.getObject());
    }
    @RequestMapping("/edit")
    @ParamNotNull(exclude = {})
    public ResponseDTO<Integer> edit(@RequestBody OperaGroupAndDetailParam params) {
        /*if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }*/
        ServiceResultDTO<Integer> resultService= operaGroupService.insert(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(String id) {
        ServiceResultDTO<Integer> deleteResult= operaGroupService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
