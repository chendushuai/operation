package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.model.OperaOs;
import com.chenss.operateapi.model.OperaServiceType;
import com.chenss.operateapi.request.OperaOsDO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 公共查询相应结果类，包含各类可能的查询结果
 * @author chenss002
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CommonQueryResponse implements Serializable {
    private static final long serialVersionUID = -8563068426032444847L;
    private List<OperaEnv> operaEnvList;
    private List<OperaAffiliation> operaAffiliationList;
    private List<OperaOs> operaOsList;
    private List<OperaServiceType> operaServiceTypeList;
}
