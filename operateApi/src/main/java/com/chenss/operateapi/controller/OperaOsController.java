package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaOs;
import com.chenss.operateapi.request.OperaOsDO;
import com.chenss.operate.ResponseResult;
import com.chenss.operateapi.service.OperaOsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务器操作系统控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/os")
@ResponseResult
public class OperaOsController extends BaseController {
    Logger logger = LoggerFactory.getLogger(OperaOsController.class);
    @Autowired
    private OperaOsService operaOsService;
    @RequestMapping("")
    @ParamNotNull(exclude = {"-1", ""})
    public List<OperaOs> query(@RequestBody OperaOsDO params) {
        ServiceResultDTO<List<OperaOs>> operaOs= operaOsService.getOs(params);
        return operaOs.getObject();
    }
    @RequestMapping("/view")
    public OperaOs viewObject(int id) {
        ServiceResultDTO<OperaOs> operaOs= operaOsService.selectByPrimaryKey(id);
        return operaOs.getObject();
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaOsDO params) {
        if (!params.validate()) {
            return new ResponseDTO<>(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaOsService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(int id) {
        ServiceResultDTO<Integer> deleteResult= operaOsService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
