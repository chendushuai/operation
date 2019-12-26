package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.request.OperaEnvDO;
import com.chenss.operateapi.service.OperaEnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 环境配置控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/env")
public class OperaEnvController extends BaseController {
    @Autowired
    private OperaEnvService operaEnvService;
    @RequestMapping("")
    @ParamNotNull(exclude = {"-1", ""})
    public ResponseDTO<List<OperaEnv>> query(@RequestBody OperaEnvDO params) {
        ServiceResultDTO<List<OperaEnv>> operaEnv= operaEnvService.getEnv(params);
        return new ResponseDTO(operaEnv.getObject());
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaEnv> viewObject(int id) {
        ServiceResultDTO<OperaEnv> operaEnv= operaEnvService.selectByPrimaryKey(id);
        return new ResponseDTO(operaEnv.getObject());
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaEnvDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaEnvService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(int id) {
        ServiceResultDTO<Integer> deleteResult= operaEnvService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
