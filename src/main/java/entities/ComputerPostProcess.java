package entities;

import interfaces.Computer;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class ComputerPostProcess implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Computer) {
            log.error("Before init message " + bean.getClass().getSimpleName());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Computer) {
            log.error("Before destroy message " + bean.getClass().getSimpleName());
        }
        return bean;
    }
}
