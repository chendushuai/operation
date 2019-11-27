package com.chenss.operateapi.common;

import cn.hutool.core.util.IdUtil;
import org.junit.Test;

public class GetUUIDTest {
    @Test
    public void getUUID() {
        for (int i = 0; i < 62; i++) {
            System.out.println(IdUtil.simpleUUID());
        }
    }
}
