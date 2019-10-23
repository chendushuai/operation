package com.chenss.operateapi;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.common.ServiceResultDTO;
import com.chenss.operateapi.model.OperaLabel;
import com.chenss.operateapi.service.OperaLabelService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperaLabelServiceTest {
    @Autowired
    private OperaLabelService operaLabelService;

    @Test
    public void insertOrUpdate() {
        OperaLabel operaLabel = new OperaLabel();
        operaLabel.setLabelGroup("test-group");
        operaLabel.setLabelKey("test-key");
        operaLabel.setLabelValue("测试输入键值信息");
        operaLabel.setLabelDesc("说明信息");
        operaLabel.setLabelRemark("备注信息");
        System.out.println(JSON.toJSONString(operaLabel));
        ServiceResultDTO<Integer> integerServiceResultDTO = operaLabelService.insertOrUpdate(operaLabel);
        Assert.assertEquals(integerServiceResultDTO.getObject().intValue(),1);

        OperaLabel param = new OperaLabel();
        param.setLabelGroup(operaLabel.getLabelGroup());
        ServiceResultDTO<List<OperaLabel>> listServiceResultDTO = operaLabelService.query(param);
        System.out.println(JSON.toJSONString(listServiceResultDTO.getObject()));
        Assert.assertEquals(listServiceResultDTO.getObject().size(),1);

        OperaLabel itemValue = listServiceResultDTO.getObject().get(0);
        Assert.assertEquals(operaLabel.getLabelGroup(),itemValue.getLabelGroup());
        Assert.assertEquals(operaLabel.getLabelKey(),itemValue.getLabelKey());

        itemValue.setLabelValue("修改输入内容");
        ServiceResultDTO<Integer> updateResult = operaLabelService.insertOrUpdate(itemValue);
        Assert.assertEquals(updateResult.getObject().intValue(),1);

        ServiceResultDTO<OperaLabel> doResult = operaLabelService.selectByPrimaryKey(itemValue.getId());
        Assert.assertEquals(doResult.getObject().toString(),itemValue.toString());

        ServiceResultDTO<Integer> deleteResult = operaLabelService.delete(doResult.getObject().getId());
        Assert.assertEquals(deleteResult.getObject().intValue(),1);


        ServiceResultDTO<OperaLabel> deleteDoResult = operaLabelService.selectByPrimaryKey(itemValue.getId());
        Assert.assertNull(deleteDoResult.getObject());
    }

    @Test
    public void update() {
        OperaLabel operaLabel = new OperaLabel();
        operaLabel.setLabelGroup("test-group");
        operaLabel.setLabelKey("test-key");

        ServiceResultDTO<List<OperaLabel>> listServiceResultDTO = operaLabelService.query(operaLabel);
        System.out.println(JSON.toJSONString(listServiceResultDTO.getObject()));
        Assert.assertEquals(listServiceResultDTO.getObject().size(),1);

        OperaLabel itemValue = listServiceResultDTO.getObject().get(0);
        Assert.assertEquals(operaLabel.getLabelGroup(),itemValue.getLabelGroup());
        Assert.assertEquals(operaLabel.getLabelKey(),itemValue.getLabelKey());

        itemValue.setLabelValue("修改输入内容");
        ServiceResultDTO<Integer> updateResult = operaLabelService.insertOrUpdate(itemValue);
        Assert.assertEquals(updateResult.getObject().intValue(),1);
    }
    @Test
    public void delete() {
        OperaLabel operaLabel = new OperaLabel();
        operaLabel.setLabelGroup("test-group");
        operaLabel.setLabelKey("test-key");

        ServiceResultDTO<List<OperaLabel>> listServiceResultDTO = operaLabelService.query(operaLabel);
        System.out.println(JSON.toJSONString(listServiceResultDTO.getObject()));
        Assert.assertEquals(listServiceResultDTO.getObject().size(),1);

        ServiceResultDTO<Integer> deleteResult = operaLabelService.delete(listServiceResultDTO.getObject().get(0).getId());
        Assert.assertEquals(deleteResult.getObject().intValue(),1);
    }
}
