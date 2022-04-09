package com.eke.extension.bfpp;

import com.eke.extension.bfpp.entity.Worker;
import com.eke.extension.bfpp.entity.Boss;
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
        ConfigurableApplicationContext ctx = SpringApplication.run(BFPPApplication.class, args);
        System.out.println("BFPPApplication  has started !! ");
        Worker worker = (Worker) ctx.getBean("myWorker");
        System.out.println("success to get myWorker = "+ worker);

        Boss boss = ctx.getBean(Boss.class);
        System.out.println("success to get boss = "+ boss);
    }
}
