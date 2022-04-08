package com.eke.bfpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/7
 */
@SpringBootApplication
public class BFPPApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BFPPApplication.class, args);
        System.out.println("BFPPApplication  has started !! ");
    }
}
