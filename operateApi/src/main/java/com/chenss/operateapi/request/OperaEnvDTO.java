package com.chenss.operateapi.request;

import com.chenss.operateapi.common.RequestParam;
import com.chenss.operateapi.model.OperaEnv;
import com.chenss.operateapi.response.IConvertDTO;
import com.chenss.utils.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author chenss002
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OperaEnvDTO implements RequestParam {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 环境类型
     */
    @NotBlank(message = "环境类型不能为空")
    private String envType;

    /**
     * 环境名称
     */
    @NotBlank(message = "环境名称不能为空")
    private String envName;

    /**
     * Apollo环境名称
     */
    private String apolloEnv;

    /**
     * 环境描述
     */
    private String envDesc;

    public OperaEnv convertToOperaEnv() {
        OperaEnvDTOConvert convert = new OperaEnvDTOConvert();
        return convert.doForward(this);
    }

    public OperaEnvDTO convertFor(OperaEnv env) {
        OperaEnvDTOConvert convert = new OperaEnvDTOConvert();
        return convert.doBackForward(env);
    }

    /**
     * 进行对象转换
     * @author chenss002
     */
    private static class OperaEnvDTOConvert implements IConvertDTO<OperaEnv,OperaEnvDTO> {
        @Override
        public OperaEnv doForward(OperaEnvDTO sourceObj) {
            OperaEnv operaEnv = new OperaEnv();
            BeanUtils.copyProperties(sourceObj,operaEnv);
            return operaEnv;
        }

        @Override
        public OperaEnvDTO doBackForward(OperaEnv targetObject) {
            OperaEnvDTO operaEnvDTO = new OperaEnvDTO();
            BeanUtils.copyProperties(targetObject,operaEnvDTO);
            return operaEnvDTO;
        }
    }
}
