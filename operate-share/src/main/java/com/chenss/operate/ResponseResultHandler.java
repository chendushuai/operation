package com.chenss.operate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultHandler.class);

    public static final String RESPONSE_RESULT="RESPONSE-RESULT";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT);
        return null != responseResultAnn;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_RESULT);
        Object objBuffer = null;
        try {
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().setHeader("requestId",request.getHeader("requestId"));
            Result result = (Result) responseResult.value().newInstance();
            result.setCode(MyResultCode.SUCCESS.getCode());
            result.setMessage(MyResultCode.SUCCESS.getMessage());
            result.setData(body);
            if (!(body instanceof String) && !aClass.isAssignableFrom(StringHttpMessageConverter.class)) {
                if (body instanceof Result) {
                    objBuffer = body;
                } else {
                    objBuffer = result;
                }
            } else {
                objBuffer=result.toJson();
            }
        } catch (IllegalAccessException | InstantiationException e) {
            objBuffer=new MyResult<>(MyResultCode.SYSTEM_INNER_ERROR);
            LOGGER.error("beforeBodyWrite got failed", e);
        }
        return objBuffer;
    }
}
