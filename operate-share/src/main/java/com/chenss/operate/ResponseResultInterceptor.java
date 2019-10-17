package com.chenss.operate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
    public static final String RESPONSE_RESULT="RESPONSE-RESULT";
    private static final String REQUEST_TIME = "REQUEST-TIME";
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultInterceptor.class);

    public ResponseResultInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT, clazz.getAnnotation(ResponseResult.class));
                request.setAttribute(REQUEST_TIME, System.currentTimeMillis());
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT, method.getAnnotation(ResponseResult.class));
                request.setAttribute(REQUEST_TIME, System.currentTimeMillis());
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class) || method.isAnnotationPresent(ResponseResult.class)) {
                String requestId = request.getHeader("requestId");
                int statusCode = response.getStatus();
                long requestTime = ((Long) request.getAttribute(REQUEST_TIME)).longValue();
                if (statusCode != HttpStatus.OK.value()) {
                    LoggerFactory.getLogger(clazz).error("RequestID: {}, Method: {}, Response Time: {}ms, HttpStatus: {}", new Object[]{requestId, method.getName(), System.currentTimeMillis() - requestTime, statusCode});
                } else {
                    LoggerFactory.getLogger(clazz).info("RequestID: {}, Method: {}, Response Time: {}ms", new Object[]{requestId, method.getName(), System.currentTimeMillis() - requestTime});
                }
            }
        }
    }
}
