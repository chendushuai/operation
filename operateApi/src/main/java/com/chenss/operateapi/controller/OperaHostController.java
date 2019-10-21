package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ParamNullProcess;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.param.OperaHostParam;
import com.chenss.operateapi.request.OperaHostDO;
import com.chenss.operateapi.response.OperaHostResponse;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaHostService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
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
    public ResponseDTO<PaginationQueryResult<OperaHostResponse>> findEnv(@RequestBody OperaHostParam params) {
        ParamNullProcess<OperaHostParam> paramNullProcess = new ParamNullProcess();
        params = paramNullProcess.process(params,"-1");
        params = copyParam(params);
        PaginationQueryResult<OperaHost> operaAff= operaHostService.pageQuery(params);

        PaginationQueryResult<OperaHostResponse> resultResponse = new PaginationQueryResult<>();
        resultResponse.setTotalSize(operaAff.getTotalSize());
        resultResponse.setResultList(convertList(operaAff.getResultList()));
        return new ResponseDTO(resultResponse);
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaHost> viewObject(String id) {
        SeviceResultDTO<OperaHost> operaAff= operaHostService.selectByPrimaryKey(id);
        return new ResponseDTO(operaAff.getObject());
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaHostDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        OperaHostDO hostDO = new OperaHostDO();
        if (!StringUtils.isNullOrEmpty(params.getId())) {
            hostDO.setId(params.getId());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostIp())) {
            hostDO.setHostIp(params.getHostIp());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostName())) {
            hostDO.setHostName(params.getHostName());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostType())) {
            hostDO.setHostType(params.getHostType());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostCpu())) {
            hostDO.setHostCpu(params.getHostCpu());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostMemory())) {
            hostDO.setHostMemory(params.getHostMemory());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostHarddisk())) {
            hostDO.setHostHarddisk(params.getHostHarddisk());
        }
        if (!StringUtils.isNullOrEmpty(params.getHostRemark())) {
            hostDO.setHostRemark(params.getHostRemark());
        }
        SeviceResultDTO<Integer> resultService= operaHostService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(String id) {
        SeviceResultDTO<Integer> deleteResult= operaHostService.delete(id);
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
    private OperaHostParam copyParam(OperaHostParam param) {
        OperaHostParam paramReturn = new OperaHostParam();
        BeanUtils.copyProperties(param,paramReturn);
        if (StringUtils.isNullOrEmpty(param.getHostName())) {
            paramReturn.setHostName(null);
        }
        if (StringUtils.isNullOrEmpty(param.getHostIp())) {
            paramReturn.setHostIp(null);
        }
        if (StringUtils.isNullOrEmpty(param.getHostType())) {
            paramReturn.setHostType(null);
        }
        if (StringUtils.isNullOrEmpty(param.getHostCpu())) {
            paramReturn.setHostCpu(null);
        }
        if (StringUtils.isNullOrEmpty(param.getHostMemory())) {
            paramReturn.setHostMemory(null);
        }
        if (StringUtils.isNullOrEmpty(param.getHostHarddisk())) {
            paramReturn.setHostHarddisk(null);
        }
        return paramReturn;
    }
}
