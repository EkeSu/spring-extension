package com.eke.extension.bp.support;

import com.eke.extension.bp.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/9
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass == User.class){
            User user = new User();
            user.setId(10086L);
            user.setName("eke...");
            System.out.println("MyInstantiationAwareBeanPostProcessor creates bean in postProcessBeforeInstantiation, user=" + user);
            return user;
        }

        return null;
    }
}
