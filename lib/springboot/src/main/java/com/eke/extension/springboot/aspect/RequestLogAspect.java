package com.eke.extension.springboot.aspect;

import com.alibaba.fastjson.JSON;
import com.eke.extension.springboot.annotation.RequestLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/5/17
 */
@Aspect
@Component
public class RequestLogAspect {
    @Around("@annotation(requestLog)")
    public Object logAround(ProceedingJoinPoint pjp, RequestLog sysLog) throws Throwable {
        if(sysLog == null){
            return pjp.proceed();
        }

        boolean printRequest = sysLog.printRequest();
        boolean printResponse = sysLog.printResponse();
        if(!printRequest && !printResponse){
            return pjp.proceed();
        }
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Method realMethod = pjp.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());
        String className = pjp.getTarget().getClass().getName();
        String methodName = className + "." + realMethod.getName();
        if(printRequest){
            Object[] args = pjp.getArgs();
            StringBuilder paramsStr = new StringBuilder();
            for (Object arg : args) {
                paramsStr.append(JSON.toJSONString(arg)).append(",");
            }
            String params;
            if(paramsStr.length() > 0){
                params = paramsStr.deleteCharAt(paramsStr.length() - 1).toString();
            }else{
                params = "null";
            }
            System.out.println(String.format("requestLog method=%s, params=%s", methodName, params));
        }

        long start = System.currentTimeMillis();
        Object object = null;
        try {
            object = pjp.proceed();
        }finally {
            long useTime = System.currentTimeMillis() - start;
            if(printResponse){
                System.out.println(String.format("requestLog method=%s, resp=%s", methodName, JSON.toJSONString(object)));
            }
            System.out.println(String.format("requestLog method=%s, use time %s ms", methodName, useTime));
        }
        return object;

    }
}
