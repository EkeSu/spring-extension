package com.eke.extension.bpp;

import com.eke.extension.bpp.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/9
 */
@SpringBootApplication
public class BPPApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BPPApplication.class, args);
        User bean = ctx.getBean(User.class);
        Object user = ctx.getBeanFactory().getSingleton("user");
        System.out.println(user);
        System.out.println("the bean is created by MyInstantiationAwareBeanPostProcessor which use new（） to create a bean， the bean = " + bean);

        ctx.close();
    }

}
