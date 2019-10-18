package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.model.OperaOs;
import com.chenss.operateapi.model.OperaServiceType;
import com.chenss.operateapi.request.CommonQueryParam;
import com.chenss.operateapi.request.OperaAffiliationDO;
import com.chenss.operateapi.response.CommonQueryResponse;
import com.chenss.operateapi.response.OperaAffiliationResponse;
import com.chenss.operateapi.service.OperaAffiliationService;
import com.chenss.operateapi.service.OperaEnvService;
import com.chenss.operateapi.service.OperaOsService;
import com.chenss.operateapi.service.OperaServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共查询控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/common")
public class CommonController extends BaseController {
    @Autowired
    private OperaEnvService operaEnvService;
    @Autowired
    private OperaAffiliationService operaAffiliationService;
    @Autowired
    private OperaOsService operaOsService;
    @Autowired
    private OperaServiceTypeService operaServiceTypeService;

    @RequestMapping("")
    public ResponseDTO<CommonQueryResponse> findEnv(@RequestBody CommonQueryParam params) {
        CommonQueryResponse commonQueryResponse = new CommonQueryResponse();
        if (params.isNeedOperaEnv()) {
            SeviceResultDTO<List<OperaEnv>> envList = operaEnvService.getEnv(new OperaEnv());
            commonQueryResponse.setOperaEnvList(envList.getObject());
        }
        if (params.isNeedOperaAffiliation()) {
            SeviceResultDTO<List<OperaAffiliation>> affList = operaAffiliationService.listAll(new OperaAffiliation());
            commonQueryResponse.setOperaAffiliationList(affList.getObject());
        }
        if (params.isNeedOperaOs()) {
            SeviceResultDTO<List<OperaOs>> osList = operaOsService.getOs(new OperaOs());
            commonQueryResponse.setOperaOsList(osList.getObject());
        }
        if (params.isNeedOperaServiceType()) {
            SeviceResultDTO<List<OperaServiceType>> serviceTypeList = operaServiceTypeService.listAll(new OperaServiceType());
            commonQueryResponse.setOperaServiceTypeList(serviceTypeList.getObject());
        }
        return new ResponseDTO(commonQueryResponse);
    }
}
