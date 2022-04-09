package com.eke.bfpp.support;

import com.eke.bfpp.entity.Boss;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/8
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerAlias("worker", "myWorker");
        beanFactory.registerSingleton("boss", new Boss());
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
    }
}
