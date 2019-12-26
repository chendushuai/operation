package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaApplication;
import com.chenss.operateapi.param.GroupApplicationParam;
import com.chenss.operateapi.request.OperaApplicationDO;
import com.chenss.operateapi.request.OperaApplicationGroupDO;
import com.chenss.operateapi.response.ApplicationGroupEnvHostDo;
import com.chenss.operateapi.response.ApplicationResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 应用管理控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/application")
public class OperaApplicationController extends BaseController {
    @Autowired
    private OperaApplicationService operaApplicationService;
    @RequestMapping("")
    @ParamNotNull(exclude = {"-1", ""})
    public ResponseDTO<PaginationQueryResult<ApplicationResponse>> query(@RequestBody GroupApplicationParam params) {
        PaginationQueryResult<ApplicationResponse> operaApplication= operaApplicationService.pageQuery(params);
        return new ResponseDTO(operaApplication);
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaApplication> viewObject(String id) {
        ServiceResultDTO<OperaApplication> operaApplication= operaApplicationService.selectByPrimaryKey(id);
        return new ResponseDTO(operaApplication.getObject());
    }
    @RequestMapping("/group/list")
    public ResponseDTO<List<ApplicationGroupEnvHostDo>> queryGroupHostId(String id) {
        ServiceResultDTO<List<ApplicationGroupEnvHostDo>> operaItem= operaApplicationService.listGroupHostInfo(id);
        return new ResponseDTO(operaItem.getObject());
    }
    @RequestMapping("/edit")
    @ParamNotNull(exclude = {"-1"})
    public ResponseDTO<Integer> edit(@RequestBody OperaApplicationDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaApplicationService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(String id) {
        ServiceResultDTO<Integer> deleteResult= operaApplicationService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/addGroup")
    @ParamNotNull(exclude = {"-1"})
    public ResponseDTO<Integer> editGroup(@RequestBody OperaApplicationGroupDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaApplicationService.insertOrUpdateApplicationGroup(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/deletegroup")
    public ResponseDTO<Integer> deleteGroup(String id) {
        ServiceResultDTO<Integer> deleteResult= operaApplicationService.deleteApplicationGroup(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
