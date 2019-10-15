package com.chenss.operateapi.controller;

import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ErrorEnum;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.request.OperaHostDO;
import com.chenss.operateapi.response.OperaHostResponse;
import com.chenss.operateapi.service.OperaHostService;
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
@RequestMapping("/api/servicetype")
public class OperaHostController extends BaseController {
    @Autowired
    private OperaHostService operaHostService;
    @RequestMapping("")
    public ResponseDTO<List<OperaHostResponse>> findEnv(@RequestBody OperaHostDO params) {
        SeviceResultDTO<List<OperaHost>> operaAff= operaHostService.listAll(params);
        return new ResponseDTO(convertList(operaAff.getObject()));
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaHostResponse> viewObject(String id) {
        SeviceResultDTO<OperaHost> operaAff= operaHostService.selectByPrimaryKey(id);
        return new ResponseDTO(new OperaHostResponse(operaAff.getObject()));
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaHostDO params) {
        if (!params.validate()) {
            return new ResponseDTO(ErrorEnum.PARAM,"参数不完整");
        }
        SeviceResultDTO<Integer> resultService= operaHostService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(ErrorEnum.ERROR,resultService.getMsg());
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(String id) {
        SeviceResultDTO<Integer> deleteResult= operaHostService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(ErrorEnum.ERROR,deleteResult.getMsg());
        }
    }
    private List<OperaHostResponse> convertList(List<OperaHost> operaHostList) {
        List<OperaHostResponse> operaHostResponses =new ArrayList<>();
        for (OperaHost item:
                operaHostList) {
            operaHostResponses.add(new OperaHostResponse(item));
        }
        return operaHostResponses;
    }
}
