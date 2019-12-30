package com.chenss.operateapi.controller;

import com.chenss.operate.MyResultCode;
import com.chenss.operateapi.BaseController;
import com.chenss.operateapi.aop.ParamNotNull;
import com.chenss.operateapi.common.ResponseDTO;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaLabel;
import com.chenss.operateapi.param.OperaLabelPageParam;
import com.chenss.operateapi.request.OperaLabelDO;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.chenss.operateapi.service.OperaLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 标签配置控制器
 * @author chenss002
 */
@RestController
@RequestMapping("/api/label")
public class OperaLabelController extends BaseController {
    @Autowired
    private OperaLabelService operaLabelService;
    @RequestMapping("")
    @ParamNotNull(exclude = {})
    public ResponseDTO<PaginationQueryResult<OperaLabel>> query(@RequestBody OperaLabelPageParam params) {
        PaginationQueryResult<OperaLabel> operaAff= operaLabelService.pageQuery(params);

        PaginationQueryResult<OperaLabel> resultResponse = new PaginationQueryResult<>();
        resultResponse.setTotalSize(operaAff.getTotalSize());
        resultResponse.setResultList(operaAff.getResultList());
        return new ResponseDTO<>(resultResponse);
    }

    /**
     * 用于标签下拉列表参数值查询
     * @param params
     * @return
     */
    @RequestMapping("/kv")
    @ParamNotNull(exclude = {})
    public ResponseDTO<List<OperaLabel>> query(@RequestBody OperaLabel params) {
        ServiceResultDTO<List<OperaLabel>> queryResult= operaLabelService.query(params);
        return new ResponseDTO(queryResult.getObject());
    }
    @RequestMapping("/view")
    public ResponseDTO<OperaLabel> viewObject(String id) {
        ServiceResultDTO<OperaLabel> operaItem= operaLabelService.selectByPrimaryKey(id);
        return new ResponseDTO(operaItem.getObject());
    }
    @RequestMapping("/edit")
    @ParamNotNull(exclude = {})
    public ResponseDTO<Integer> edit(@RequestBody OperaLabelDO params) {
        if (!params.validate()) {
            return new ResponseDTO<>(MyResultCode.PARAM_IS_BLANK);
        }
        ServiceResultDTO<Integer> resultService= operaLabelService.insertOrUpdate(params);
        if (resultService.isSuccess()) {
            return new ResponseDTO<>(resultService.getObject());
        } else {
            return new ResponseDTO<>(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
    @RequestMapping("/delete")
    public ResponseDTO<Integer> delete(String id) {
        ServiceResultDTO<Integer> deleteResult= operaLabelService.delete(id);
        if (deleteResult.isSuccess()) {
            return new ResponseDTO(deleteResult.getObject());
        } else {
            return new ResponseDTO(MyResultCode.SYSTEM_INNER_ERROR);
        }
    }
}
