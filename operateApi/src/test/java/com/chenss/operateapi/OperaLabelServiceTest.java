package com.chenss.operateapi;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.common.SeviceResultDTO;
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
        SeviceResultDTO<Integer> integerSeviceResultDTO = operaLabelService.insertOrUpdate(operaLabel);
        Assert.assertEquals(integerSeviceResultDTO.getObject().intValue(),1);

        OperaLabel param = new OperaLabel();
        param.setLabelGroup(operaLabel.getLabelGroup());
        SeviceResultDTO<List<OperaLabel>> listSeviceResultDTO = operaLabelService.query(param);
        System.out.println(JSON.toJSONString(listSeviceResultDTO.getObject()));
        Assert.assertEquals(listSeviceResultDTO.getObject().size(),1);

        OperaLabel itemValue = listSeviceResultDTO.getObject().get(0);
        Assert.assertEquals(operaLabel.getLabelGroup(),itemValue.getLabelGroup());
        Assert.assertEquals(operaLabel.getLabelKey(),itemValue.getLabelKey());

        itemValue.setLabelValue("修改输入内容");
        SeviceResultDTO<Integer> updateResult = operaLabelService.insertOrUpdate(itemValue);
        Assert.assertEquals(updateResult.getObject().intValue(),1);

        SeviceResultDTO<OperaLabel> doResult = operaLabelService.selectByPrimaryKey(itemValue.getId());
        Assert.assertEquals(doResult.getObject().toString(),itemValue.toString());

        SeviceResultDTO<Integer> deleteResult = operaLabelService.delete(doResult.getObject().getId());
        Assert.assertEquals(deleteResult.getObject().intValue(),1);


        SeviceResultDTO<OperaLabel> deleteDoResult = operaLabelService.selectByPrimaryKey(itemValue.getId());
        Assert.assertNull(deleteDoResult.getObject());
    }

    @Test
    public void update() {
        OperaLabel operaLabel = new OperaLabel();
        operaLabel.setLabelGroup("test-group");
        operaLabel.setLabelKey("test-key");

        SeviceResultDTO<List<OperaLabel>> listSeviceResultDTO = operaLabelService.query(operaLabel);
        System.out.println(JSON.toJSONString(listSeviceResultDTO.getObject()));
        Assert.assertEquals(listSeviceResultDTO.getObject().size(),1);

        OperaLabel itemValue = listSeviceResultDTO.getObject().get(0);
        Assert.assertEquals(operaLabel.getLabelGroup(),itemValue.getLabelGroup());
        Assert.assertEquals(operaLabel.getLabelKey(),itemValue.getLabelKey());

        itemValue.setLabelValue("修改输入内容");
        SeviceResultDTO<Integer> updateResult = operaLabelService.insertOrUpdate(itemValue);
        Assert.assertEquals(updateResult.getObject().intValue(),1);
    }
    @Test
    public void delete() {
        OperaLabel operaLabel = new OperaLabel();
        operaLabel.setLabelGroup("test-group");
        operaLabel.setLabelKey("test-key");

        SeviceResultDTO<List<OperaLabel>> listSeviceResultDTO = operaLabelService.query(operaLabel);
        System.out.println(JSON.toJSONString(listSeviceResultDTO.getObject()));
        Assert.assertEquals(listSeviceResultDTO.getObject().size(),1);

        SeviceResultDTO<Integer> deleteResult = operaLabelService.delete(listSeviceResultDTO.getObject().get(0).getId());
        Assert.assertEquals(deleteResult.getObject().intValue(),1);
    }
}
