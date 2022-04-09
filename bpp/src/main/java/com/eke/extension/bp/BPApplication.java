package com.eke.extension.bp;

import com.eke.extension.bp.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/9
 */
@SpringBootApplication
public class BPApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BPApplication.class, args);
        User bean = ctx.getBean(User.class);
        System.out.println("the bean is created by MyInstantiationAwareBeanPostProcessor which use new（） to create a bean， the bean = " + bean);
    }

}
