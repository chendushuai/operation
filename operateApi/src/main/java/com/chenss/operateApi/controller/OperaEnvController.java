package com.chenss.operateApi.controller;

import com.chenss.operateApi.BaseController;
import com.chenss.operateApi.common.SeviceResultDTO;
import com.chenss.operateApi.model.OperaEnv;
import com.chenss.operateApi.service.OperaEnvService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/env")
public class OperaEnvController extends BaseController {
    @Autowired
    private OperaEnvService operaEnvService;
    @RequestMapping("")
    public ResponseEntity<List<OperaEnv>> findEnv(OperaEnv params) {
        SeviceResultDTO<List<OperaEnv>> operaEnv= operaEnvService.getEnv(params);
        return ResponseEntity.ok(operaEnv.getObject());
        //return "[OperaEnv [Hash = -1782734848, id=1, envType=DEV, envName=开发环境, apolloEnv=DEV, envDesc=开发环境, serialVersionUID=1], OperaEnv [Hash = 1949561467, id=2, envType=TEST, envName=测试环境, apolloEnv=QA, envDesc=测试环境, serialVersionUID=1], OperaEnv [Hash = -323490972, id=3, envType=UAT, envName=UAT预发环境, apolloEnv=UAT, envDesc=UAT预发环境, serialVersionUID=1], OperaEnv [Hash = 1255912080, id=4, envType=HZ, envName=富阳环境, apolloEnv=ONLINE_FY, envDesc=富阳生产环境, serialVersionUID=1], OperaEnv [Hash = 327114008, id=5, envType=SZ, envName=苏州环境, apolloEnv=ONLINE, envDesc=苏州生产环境, serialVersionUID=1]]";
    }
    @RequestMapping("/view")
    public ResponseEntity<OperaEnv> viewObject(int id) {
        SeviceResultDTO<OperaEnv> operaEnv= operaEnvService.selectByPrimaryKey(id);
        return ResponseEntity.ok(operaEnv.getObject());
    }
}
