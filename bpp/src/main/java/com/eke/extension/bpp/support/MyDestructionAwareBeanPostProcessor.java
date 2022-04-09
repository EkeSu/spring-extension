package com.eke.extension.bpp.support;

import com.eke.extension.bpp.entity.User;
import com.eke.extension.bpp.entity.Worker;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/9
 */
@Component
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == User.class || bean.getClass() == Worker.class){
            System.out.println(String.format("yes, %s is destroying， could you find User class", beanName));
        }

    }

    @Override
    public boolean requiresDestruction(Object bean) {
        return true;
    }
}
