package com.chenss.operateapi.response;

import com.chenss.operateapi.model.OperaAffiliation;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.model.OperaOs;
import com.chenss.operateapi.model.OperaServiceType;
import com.chenss.operateapi.request.OperaOsDO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 公共查询相应结果类，包含各类可能的查询结果
 * @author chenss002
 */
public class CommonQueryResponse implements Serializable {
    private static final long serialVersionUID = -8563068426032444847L;
    private List<OperaEnv> operaEnvList;
    private List<OperaAffiliation> operaAffiliationList;
    private List<OperaOs> operaOsList;
    private List<OperaServiceType> operaServiceTypeList;

    public List<OperaEnv> getOperaEnvList() {
        return operaEnvList;
    }

    public void setOperaEnvList(List<OperaEnv> operaEnvList) {
        this.operaEnvList = operaEnvList;
    }

    public List<OperaAffiliation> getOperaAffiliationList() {
        return operaAffiliationList;
    }

    public void setOperaAffiliationList(List<OperaAffiliation> operaAffiliationList) {
        this.operaAffiliationList = operaAffiliationList;
    }

    public List<OperaOs> getOperaOsList() {
        return operaOsList;
    }

    public void setOperaOsList(List<OperaOs> operaOsList) {
        this.operaOsList = operaOsList;
    }

    public List<OperaServiceType> getOperaServiceTypeList() {
        return operaServiceTypeList;
    }

    public void setOperaServiceTypeList(List<OperaServiceType> operaServiceTypeList) {
        this.operaServiceTypeList = operaServiceTypeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        CommonQueryResponse that = (CommonQueryResponse) o;
        return Objects.equals(operaEnvList, that.operaEnvList) &&
                Objects.equals(operaAffiliationList, that.operaAffiliationList) &&
                Objects.equals(operaOsList, that.operaOsList) &&
                Objects.equals(operaServiceTypeList, that.operaServiceTypeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operaEnvList, operaAffiliationList, operaOsList, operaServiceTypeList);
    }

    @Override
    public String toString() {
        return "CommonQueryResponse{" +
                "operaEnvList=" + operaEnvList +
                ", operaAffiliationList=" + operaAffiliationList +
                ", operaOsList=" + operaOsList +
                ", operaServiceTypeList=" + operaServiceTypeList +
                '}';
    }
}
