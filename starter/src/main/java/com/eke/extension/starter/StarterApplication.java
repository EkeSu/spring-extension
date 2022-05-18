package com.eke.extension.starter;

import com.eke.extension.springboot.entity.CClass;
import com.eke.extension.springboot.exclude.DClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/11
 */
@SpringBootApplication
public class StarterApplication {
//
//    @Autowired
//    private ApplicationTaskExecutor applicationTaskExecutor;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(StarterApplication.class, args);

        CClass bean = ctx.getBean(CClass.class);
        System.out.println(bean);

        DClass otherClass = ctx.getBean(DClass.class);
        System.out.println(otherClass);
    }
}
