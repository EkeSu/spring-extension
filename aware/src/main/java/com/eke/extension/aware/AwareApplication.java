package com.eke.extension.aware;

import com.eke.extension.aware.entity.User;
import com.eke.extension.aware.support.ApplicationContextUtil;
import com.eke.extension.aware.support.EnvironmentUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/7
 */
@SpringBootApplication
public class AwareApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AwareApplication.class, args);
        System.out.println("application has started");

        ApplicationContextUtil applicationContextUtil = run.getBean(ApplicationContextUtil.class);
        User user = (User)applicationContextUtil.getBean("user");
        System.out.println("get user successful, user=" + user);
        EnvironmentUtil environmentUtil = run.getBean(EnvironmentUtil.class);
        String property = environmentUtil.getProperty("aware.key");
        System.out.println("get aware.key sucessful, value = " + property);

    }
}
