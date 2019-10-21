package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
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
    public List<OperaOs> findOs(@RequestBody OperaOsDO params) {
        SeviceResultDTO<List<OperaOs>> operaOs= operaOsService.getOs(params);
        return operaOs.getObject();
        //return "[OperaOs [Hash = -1782734848, id=1, envType=DEV, envName=开发环境, apolloOs=DEV, envDesc=开发环境, serialVersionUID=1], OperaOs [Hash = 1949561467, id=2, envType=TEST, envName=测试环境, apolloOs=QA, envDesc=测试环境, serialVersionUID=1], OperaOs [Hash = -323490972, id=3, envType=UAT, envName=UAT预发环境, apolloOs=UAT, envDesc=UAT预发环境, serialVersionUID=1], OperaOs [Hash = 1255912080, id=4, envType=HZ, envName=富阳环境, apolloOs=ONLINE_FY, envDesc=富阳生产环境, serialVersionUID=1], OperaOs [Hash = 327114008, id=5, envType=SZ, envName=苏州环境, apolloOs=ONLINE, envDesc=苏州生产环境, serialVersionUID=1]]";
    }
    @RequestMapping("/view")
    public OperaOs viewObject(int id) {
        SeviceResultDTO<OperaOs> operaOs= operaOsService.selectByPrimaryKey(id);
        return operaOs.getObject();
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaOsDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        SeviceResultDTO<Integer> resultService= operaOsService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(int id) {
        SeviceResultDTO<Integer> deleteResult= operaOsService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
