package com.eke.extension.bdrpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/8
 */
@SpringBootApplication
public class BDRPPApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BDRPPApplication.class, args);
        Object eke = ctx.getBean("ILikeThisName");
        System.out.println("sucess to getting eke bean = "+eke);
    }
}
