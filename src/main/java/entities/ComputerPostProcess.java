package entities;

import interfaces.Computer;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Log4j
public class ComputerPostProcess implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean == null) {
            throw new NullPointerException();
        }
        if (bean instanceof Computer) {
            log.info("Before init message " + bean.getClass().getSimpleName());
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean == null) {
            throw new NullPointerException();
        }
        if (bean instanceof Computer) {
            log.info("Before destroy message " + bean.getClass().getSimpleName());
        }
        return bean;
    }
}
