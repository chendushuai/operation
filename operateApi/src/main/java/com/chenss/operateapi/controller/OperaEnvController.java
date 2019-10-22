package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.SeviceResultDTO;
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
    public ResponseDTO<List<OperaEnv>> query(@RequestBody OperaEnvDO params) {
        SeviceResultDTO<List<OperaEnv>> operaEnv= operaEnvService.getEnv(params);
        return new ResponseDTO(operaEnv.getObject());
        //return "[OperaEnv [Hash = -1782734848, id=1, envType=DEV, envName=开发环境, apolloEnv=DEV, envDesc=开发环境, serialVersionUID=1], OperaEnv [Hash = 1949561467, id=2, envType=TEST, envName=测试环境, apolloEnv=QA, envDesc=测试环境, serialVersionUID=1], OperaEnv [Hash = -323490972, id=3, envType=UAT, envName=UAT预发环境, apolloEnv=UAT, envDesc=UAT预发环境, serialVersionUID=1], OperaEnv [Hash = 1255912080, id=4, envType=HZ, envName=富阳环境, apolloEnv=ONLINE_FY, envDesc=富阳生产环境, serialVersionUID=1], OperaEnv [Hash = 327114008, id=5, envType=SZ, envName=苏州环境, apolloEnv=ONLINE, envDesc=苏州生产环境, serialVersionUID=1]]";
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaEnv> viewObject(int id) {
        SeviceResultDTO<OperaEnv> operaEnv= operaEnvService.selectByPrimaryKey(id);
        return new ResponseDTO(operaEnv.getObject());
    }
    @RequestMapping("/edit")
    public ResponseDTO<Integer> edit(@RequestBody OperaEnvDO params) {
        if (!params.validate()) {
            return new ResponseDTO(MyResultCode.PARAM_IS_BLANK);
        }
        SeviceResultDTO<Integer> resultService= operaEnvService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO(resultService.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(int id) {
        SeviceResultDTO<Integer> deleteResult= operaEnvService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
