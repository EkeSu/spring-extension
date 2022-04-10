package com.eke.extension.factorybean;

import com.eke.extension.factorybean.entity.MyFactoryBean;
import com.eke.extension.factorybean.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/10
 */
@SpringBootApplication
public class FactoryBeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FactoryBeanApplication.class, args);
        MyFactoryBean myFactoryBeanFromGetBean = ctx.getBean(MyFactoryBean.class);
        MyFactoryBean myFactoryBeanFromCache = (MyFactoryBean)ctx.getBeanFactory().getSingleton("myFactoryBean");
        MyFactoryBean myFactoryBean = (MyFactoryBean)ctx.getBean("&myFactoryBean");

        if(myFactoryBeanFromGetBean == myFactoryBeanFromGetBean && myFactoryBeanFromCache == myFactoryBean){
            System.out.println("哇 !!!  they are same !!!");
        }

        User user = ctx.getBean(User.class);
        User user2 = (User)ctx.getBean("myFactoryBean");

        if(user == user2){
            System.out.println("哇 ！！ user is same， too");
        }

        User userFromCache = (User)ctx.getBeanFactory().getSingleton("user");
        if(userFromCache == null){
            System.out.println("咦呀～, user is not in singletonObjects, why? the answer is in README.md");
        }
    }
}
