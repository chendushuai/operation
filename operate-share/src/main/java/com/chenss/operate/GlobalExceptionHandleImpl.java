package com.chenss.operate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ConditionalOnBean({ResponseResultInterceptor.class})
public class GlobalExceptionHandleImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultHandler.class);

    @ExceptionHandler(value = MyException.class)
    public MyResult<Object> handleSaeException(MyException myException, HttpServletRequest request) {
        LOGGER.error(myException.getCode(),myException.getMessage());
        return new MyResult<>(myException.getCode(),myException.getMessage(),null);
    }
}