package com.chenss.operateapi.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ApplicationGroupEnvHostDo extends EnvHostDO {
    @Getter
    @Setter
    private String groupId;
    @Getter
    @Setter
    private String groupName;
}
