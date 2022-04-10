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
public class GenericBPPApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GenericBPPApplication.class, args);
    }

}
