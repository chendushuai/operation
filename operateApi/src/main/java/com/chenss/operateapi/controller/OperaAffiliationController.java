package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.request.OperaAffiliationDO;
import com.chenss.operateapi.response.OperaAffiliationResponse;
import com.chenss.operateapi.service.OperaAffiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 归属管理控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/affiliation")
public class OperaAffiliationController extends BaseController {
    @Autowired
    private OperaAffiliationService operaAffiliationService;
    @RequestMapping("")
    public ResponseDTO<List<OperaAffiliationResponse>> findEnv(@RequestBody OperaAffiliationDO params) {
        SeviceResultDTO<List<OperaAffiliation>> operaAff= operaAffiliationService.listAll(params);
        return new ResponseDTO(convertList(operaAff.getObject()));
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaAffiliationResponse> viewObject(int id) {
        SeviceResultDTO<OperaAffiliation> operaAff= operaAffiliationService.selectByPrimaryKey(id);
        return new ResponseDTO(new OperaAffiliationResponse(operaAff.getObject()));
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaAffiliationDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK,"参数不完整");
        }
        SeviceResultDTO<Integer> resultService= operaAffiliationService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR,resultService.getMsg());
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(int id) {
        SeviceResultDTO<Integer> deleteResult= operaAffiliationService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR,deleteResult.getMsg());
        }
    }
    private List<OperaAffiliationResponse> convertList(List<OperaAffiliation> operaAffiliationList) {
        List<OperaAffiliationResponse> operaAffiliationResponses =new ArrayList<>();
        for (OperaAffiliation item:
                operaAffiliationList) {
            operaAffiliationResponses.add(new OperaAffiliationResponse(item));
        }
        return operaAffiliationResponses;
    }
}
