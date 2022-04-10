package com.eke.extension.bpp;

import com.eke.extension.bpp.entity.Pig;
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
public class BPPMergedBeanDefinitionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BPPMergedBeanDefinitionApplication.class, args);
        Pig pig = ctx.getBean(Pig.class);
        System.out.println(pig);
    }

}
