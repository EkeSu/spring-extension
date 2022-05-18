package com.eke.extension.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/5/17
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestLog {
    boolean printRequest() default true;
    boolean printResponse() default false;
}
