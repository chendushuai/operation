package com.chenss.operateapi.common;

import com.chenss.operateapi.common.GuidUtils;
import org.junit.Test;

public class GetUUIDTest {
    @Test
    public void getUUID() {
        for (int i = 0; i < 20; i++) {
            System.out.println(GuidUtils.getUUID());
        }
    }
}
