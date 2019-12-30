package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.request.OperaEnvDTO;
import com.chenss.operateapi.service.OperaEnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseDTO<List<OperaEnvDTO>> query(@RequestBody OperaEnvDTO params) {
        ServiceResultDTO<List<OperaEnv>> operaEnv= operaEnvService.getEnv(params.convertToOperaEnv());
        if (!operaEnv.isSuccess() || operaEnv.getObject() == null) {
            return new ResponseDTO<>(MyResultCode.SYSTEM_INNER_ERROR);
        }
        List<OperaEnvDTO> dtoList = operaEnv.getObject().stream().map(m -> params.convertFor(m)).collect(Collectors.toList());
        return new ResponseDTO(dtoList);
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaEnvDTO> viewObject(int id) {
        ServiceResultDTO<OperaEnv> operaEnv= operaEnvService.selectByPrimaryKey(id);
        return new ResponseDTO(new OperaEnvDTO().convertFor(operaEnv.getObject()));
    }
    @RequestMapping("/edit")
    @ParamNotNull(exclude = {"-1", ""})
    public ResponseDTO<Integer> edit(@RequestBody @Valid OperaEnvDTO params) {
        ServiceResultDTO<Integer> resultService= operaEnvService.insertOrUpdate(params.convertToOperaEnv());
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
