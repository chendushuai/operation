package com.chenss.operateapi.controller;

import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ErrorEnum;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.request.OperaAffiliationDO;
import com.chenss.operateapi.request.OperaEnvDO;
import com.chenss.operateapi.service.OperaAffiliationService;
import com.chenss.operateapi.service.OperaEnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseDTO<List<OperaAffiliation>> findEnv(@RequestBody OperaAffiliationDO params) {
        SeviceResultDTO<List<OperaAffiliation>> operaAff= operaAffiliationService.getEnv(params);
        return new ResponseDTO(operaAff.getObject());
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaAffiliation> viewObject(int id) {
        SeviceResultDTO<OperaAffiliation> operaAff= operaAffiliationService.selectByPrimaryKey(id);
        return new ResponseDTO(operaAff.getObject());
    }
    @RequestMapping("/edit")
    public ResponseDTO<List<OperaAffiliation>> edit(@RequestBody OperaAffiliationDO params) {
        if (!params.validate()) {
            return new ResponseDTO(ErrorEnum.PARAM,"参数不完整");
        }
        SeviceResultDTO<Integer> resultService= operaAffiliationService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(ErrorEnum.ERROR,resultService.getMsg());
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<List<OperaEnv>> delete(int id) {
        SeviceResultDTO<Integer> deleteResult= operaAffiliationService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(ErrorEnum.ERROR,deleteResult.getMsg());
        }
    }
}
