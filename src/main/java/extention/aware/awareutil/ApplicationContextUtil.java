package extention.aware.awareutil;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author：eke
 * @Date：2022/4/7
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T> T getBean(String beanName){
        Object bean = applicationContext.getBean(beanName);
        if(bean != null){
            return (T)bean;
        }

        return null;
    }


}
