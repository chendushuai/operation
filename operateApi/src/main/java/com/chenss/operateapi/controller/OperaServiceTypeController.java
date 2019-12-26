package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaServiceType;
import com.chenss.operateapi.request.OperaServiceTypeDO;
import com.chenss.operateapi.response.OperaServiceTypeResponse;
import com.chenss.operateapi.service.OperaServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务类型控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/servicetype")
public class OperaServiceTypeController extends BaseController {
    @Autowired
    private OperaServiceTypeService operaServiceTypeService;
    @RequestMapping("")
    public ResponseDTO<List<OperaServiceTypeResponse>> query(@RequestBody OperaServiceTypeDO params) {
        ServiceResultDTO<List<OperaServiceType>> operaAff= operaServiceTypeService.listAll(params);
        return new ResponseDTO(convertList(operaAff.getObject()));
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaServiceTypeResponse> viewObject(int id) {
        ServiceResultDTO<OperaServiceType> operaAff= operaServiceTypeService.selectByPrimaryKey(id);
        return new ResponseDTO(new OperaServiceTypeResponse(operaAff.getObject()));
    }
    @RequestMapping("/edit")
    @SuppressWarnings("unchecked")
    public ResponseDTO<Integer> edit(@RequestBody OperaServiceTypeDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaServiceTypeService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    @SuppressWarnings("unchecked")
    public ResponseDTO<Integer> delete(int id) {
        ServiceResultDTO<Integer> deleteResult= operaServiceTypeService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    private List<OperaServiceTypeResponse> convertList(List<OperaServiceType> operaServiceTypeList) {
        List<OperaServiceTypeResponse> operaServiceTypeResponses =new ArrayList<>();
        for (OperaServiceType item:
                operaServiceTypeList) {
            operaServiceTypeResponses.add(new OperaServiceTypeResponse(item));
        }
        return operaServiceTypeResponses;
    }
}
