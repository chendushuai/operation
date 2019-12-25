package com.chenss.operateapi.aop;

import com.alibaba.fastjson.JSON;
import com.chenss.operateapi.common.ParamNullProcess;
import com.chenss.operateapi.common.RequestParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 拦截控制器参数
 * @author chenss002
 * @date 2019-10-21 19:01:01
 */
@Component
@Aspect
public class ControllParamAspectJ {
    Logger logger = LoggerFactory.getLogger(ControllParamAspectJ.class);
    @Pointcut("@annotation(com.chenss.operateapi.aop.ParamNotNull)")
    public void pointCut() {

    }
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ParamNotNull anno = methodSignature.getMethod().getAnnotation(ParamNotNull.class);
        String[] encludes = anno.exclude();
        Object[] args = joinPoint.getArgs();
        logger.info("参数清除空值拦截，方法名:[{}],参数值：[{}],排除值：{}",methodSignature.getMethod().getDeclaringClass().getName()+"#"+methodSignature.getMethod().getName(), JSON.toJSONString(args),Arrays.toString(encludes));
        for (int i = 0; i < args.length; i++) {
            Class<?> clazz = args[i].getClass();
            if (args[i] instanceof RequestParam) {
                logger.info("参数清除空值拦截，拦截处理参数对象：{}，值：{}",clazz.getName(),JSON.toJSONString(args[i]));
                System.out.println(args[i].getClass());
                ParamNullProcess paramParamNullProcess = new ParamNullProcess();
                args[i] = paramParamNullProcess.process(args[i],clazz,encludes);
                logger.info("参数清除空值拦截，拦截处理结果对象：{}，值：{}",clazz.getName(),JSON.toJSONString(args[i]));
            }
        }
    }

    /*@Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) {
        Object[] objects = pjp.getArgs();
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        ParamNotNull anno = methodSignature.getMethod().getAnnotation(ParamNotNull.class);
        String[] encludes = anno.exclude();
        logger.info("参数清除空值拦截，方法名:[{}],参数值：[{}],排除值：{}",methodSignature.getMethod().getName(), JSON.toJSONString(objects),Arrays.toString(encludes));

        for (Object obj :
                objects) {
            logger.info("方法参数类型：{}",obj.getClass());
        }
        try {
            pjp.proceed(objects);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/
}
