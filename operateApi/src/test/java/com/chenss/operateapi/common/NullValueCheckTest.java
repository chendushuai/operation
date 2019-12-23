package com.chenss.operateapi.common;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.utils.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;

public class NullValueCheckTest {
    @Test
    public void checkNull() throws IllegalAccessException {
        OperaHost host = new OperaHost();
        host.setId("");
        host.setHostName("212");
        host.setHostIp("2111");
        host.setStatus(-1);
        host.setAffName("");
        host.setHostOsId(4);
        host.setHostEnvId(-1);
        System.out.println(JSON.toJSONString(host));
        
        Class<?> clazz = host.getClass();
        Field[] classFields = clazz.getDeclaredFields();
        for (Field fieldItem :
                classFields) {
            fieldItem.setAccessible(true);
            Object obj = fieldItem.get(host);
            if (null == obj || StringUtils.isNullOrEmpty(obj.toString())) {
                System.out.println("fieldName: " + fieldItem.getName() + "  value: " + obj);
                fieldItem.set(host, null);
            }
        }
        System.out.println(JSON.toJSONString(host));
    }
    @Test
    public void testCommonClass() {
        OperaHost host = new OperaHost();
        host.setId("");
        host.setHostName("212");
        host.setHostIp("2111");
        host.setStatus(-1);
        host.setAffName("");
        host.setHostOsId(4);
        host.setHostEnvId(-1);
        System.out.println(JSON.toJSONString(host));
        ParamNullProcess<OperaHost> paramNullProcess = new ParamNullProcess<>();

        host = paramNullProcess.process(host,"-1","4");

        System.out.println(JSON.toJSONString(host));
    }
}
