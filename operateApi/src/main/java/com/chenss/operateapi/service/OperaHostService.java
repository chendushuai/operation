package com.chenss.operateapi.service;

import com.chenss.operateapi.common.BaseUtils;
import com.chenss.operateapi.common.GuidUtils;
import com.chenss.operateapi.common.SeviceResultDTO;
import com.chenss.operateapi.mapper.OperaHostMapper;
import com.chenss.operateapi.model.OperaHost;
import com.chenss.operateapi.param.OperaHostParam;
import com.chenss.operateapi.response.PaginationQueryResult;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenss002
 */
@Service
public class OperaHostService {
    @Autowired
    private OperaHostMapper operaHostMapper;

    public SeviceResultDTO<List<OperaHost>> listAll(OperaHost operaHost) {
        OperaHost param = new OperaHost();
        if (operaHost.getId() != null) {
            param.setId(operaHost.getId());
        }
        param.setHostName(BaseUtils.getString(operaHost.getHostName()));
        param.setCreateTimeBegin(BaseUtils.getString(operaHost.getCreateTimeBegin()));
        param.setCreateTimeEnd(BaseUtils.getString(operaHost.getCreateTimeEnd()));
        param.setModifyTimeBegin(BaseUtils.getString(operaHost.getModifyTimeBegin()));
        param.setModifyTimeEnd(BaseUtils.getString(operaHost.getModifyTimeEnd()));
        return new SeviceResultDTO<>(true, operaHostMapper.query(param));
    }

    public SeviceResultDTO<OperaHost> selectByPrimaryKey(String id) {
        return new SeviceResultDTO<>(true, operaHostMapper.selectByPrimaryKey(id));
    }

    public SeviceResultDTO<Integer> insertOrUpdate(OperaHost obj) {
        OperaHost param = new OperaHost();
        param.setHostIp(obj.getHostIp());
        List<OperaHost> operaHosts = operaHostMapper.query(param);
        if (null != operaHosts && operaHosts.size() > 0) {
            if (obj.getId() == null || !operaHosts.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<Integer>().fail("服务器IP地址已经存在，无法插入");
            }
        }
        param = new OperaHost();
        param.setHostName(obj.getHostName());
        operaHosts = operaHostMapper.query(param);
        if (null != operaHosts && operaHosts.size() > 0) {
            if (obj.getId() == null || !operaHosts.get(0).getId().equals(obj.getId())) {
                return new SeviceResultDTO<Integer>().fail("服务器主机名称已经存在，无法插入");
            }
        }

        param.setHostIp(obj.getHostIp());
        param.setHostType(obj.getHostType());
        param.setHostRemark(obj.getHostRemark());
        param.setStatus(obj.getStatus());
        param.setHostCpu(obj.getHostCpu());
        param.setHostMemory(obj.getHostMemory());
        param.setHostHarddisk(obj.getHostHarddisk());
        param.setOsName(obj.getOsName());
        param.setOsVersion(obj.getOsVersion());
        param.setEnvName(obj.getEnvName());
        param.setAffName(obj.getAffName());
        param.setServiceName(obj.getServiceName());
        param.setServiceType(obj.getServiceType());
        if (obj.getId() == null) {
            param.setId(GuidUtils.getUUID());
            int insertResult = operaHostMapper.insertSelective(param);
            return new SeviceResultDTO<Integer>().ok(insertResult);
        }
        OperaHost opera = operaHostMapper.selectByPrimaryKey(obj.getId());
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法修改");
        }
        param.setId(obj.getId());
        int updateResult = operaHostMapper.updateByPrimaryKeySelective(param);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public SeviceResultDTO<Integer> delete(String id) {
        OperaHost opera = operaHostMapper.selectByPrimaryKey(id);
        if (null == opera) {
            return new SeviceResultDTO<Integer>().fail("对象不存在无法删除");
        }
        int updateResult = operaHostMapper.deleteByPrimaryKey(id);
        return new SeviceResultDTO<Integer>().ok(updateResult);
    }

    public PaginationQueryResult<OperaHost> pageQuery(OperaHostParam param) {
        PaginationQueryResult<OperaHost> result = new PaginationQueryResult<OperaHost>();
        int totalSize = operaHostMapper.countListPaging(param);
        if (totalSize>0) {
            List<OperaHost> operaHostList = operaHostMapper.listPaging(param);
            result.setResultList(operaHostList);
        }
        result.setTotalSize(totalSize);
        return result;
    }
}
