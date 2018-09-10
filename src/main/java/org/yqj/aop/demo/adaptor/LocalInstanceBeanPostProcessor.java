package org.yqj.aop.demo.adaptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.yqj.aop.demo.service.TeacherService;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * @author yaoqijun on 2018-04-08.
 */
@Component
@Slf4j
public class LocalInstanceBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware {

    public LocalInstanceBeanPostProcessor(){
        log.info("construct time");
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.equals(TeacherService.class)){
            log.info("******* teacherService before instance before instance");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == TeacherService.class){
            log.info("****** teacherService after instance ");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean.getClass() == TeacherService.class){
            log.info("******* teacher service post process property values ");
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == TeacherService.class){
            log.info("******* teacher service before init");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (AopUtils.getTargetClass(bean) == TeacherService.class) {
            log.info("******* teacher service after init");
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("bean factory is in hahah");
    }
}
