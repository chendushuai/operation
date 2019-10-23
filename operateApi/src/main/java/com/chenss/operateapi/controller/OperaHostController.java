package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.param.OperaHostParam;
import com.chenss.operateapi.request.OperaHostDO;
import com.chenss.operateapi.response.OperaHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 主机管理控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/host")
public class OperaHostController extends BaseController {
    @Autowired
    private OperaHostService operaHostService;
    @RequestMapping("")
    @ParamNotNull(exclude = {"-1"})
    public ResponseDTO<PaginationQueryResult<OperaHostResponse>> query(@RequestBody OperaHostParam params) {
        PaginationQueryResult<OperaHost> operaAff= operaHostService.pageQuery(params);

        PaginationQueryResult<OperaHostResponse> resultResponse = new PaginationQueryResult<>();
        resultResponse.setTotalSize(operaAff.getTotalSize());
        resultResponse.setResultList(convertList(operaAff.getResultList()));
        return new ResponseDTO(resultResponse);
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaHost> viewObject(String id) {
        ServiceResultDTO<OperaHost> operaAff= operaHostService.selectByPrimaryKey(id);
        return new ResponseDTO(operaAff.getObject());
    }
    @RequestMapping("/edit")
    @ParamNotNull(exclude = {"-1"})
    public ResponseDTO<Integer> edit(@RequestBody OperaHostDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaHostService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(String id) {
        ServiceResultDTO<Integer> deleteResult= operaHostService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    private List<OperaHostResponse> convertList(List<OperaHost> operaHostList) {
        List<OperaHostResponse> operaHostResponses =new ArrayList<>();
        if (null == operaHostList) {
            return operaHostResponses;
        }
        for (OperaHost item:
                operaHostList) {
            operaHostResponses.add(new OperaHostResponse(item));
        }
        return operaHostResponses;
    }
}
