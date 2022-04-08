package extention.aware.awareutil;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/7
 */
@Component
public class BeanFactoryUtil implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public <T> T getBean(String beanName){
        Object bean = beanFactory.getBean(beanName);
        if(bean != null){
            return (T)bean;
        }

        return null;
    }
}
