package com.eke.extension.springboot;

import com.eke.extension.springboot.exclude.DClass;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**c
 * @Description：
 * @Author：eke
 * @Date：2022/4/11
 */
@Configuration
@ComponentScan(basePackages = "com.eke.extension.springboot.entity")
public class Application {

    @Configuration
    static class ConfigClass {
        ConfigClass(BeanFactory beanFactory) {
            System.out.println("do something with beanFactory="+beanFactory);
        }
    }

    @Bean
    public DClass getOtherClass(){
        return new DClass();
    }

}
