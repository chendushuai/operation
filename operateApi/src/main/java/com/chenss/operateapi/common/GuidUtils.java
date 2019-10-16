package com.chenss.operateapi.common;

import java.util.UUID;

public class GuidUtils {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String idString = uuid.toString().toUpperCase().replaceAll("-","");
        return idString;
    }
}
