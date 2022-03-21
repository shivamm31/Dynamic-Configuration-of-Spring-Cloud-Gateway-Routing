package com.xinyue.app.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
@Service
public class BeanPostProcessorImpl implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("appController")) {
            System.out.println("====执行postProcessBeforeInitialization=====");
        }
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("appController")) {
            System.out.println("====执行postProcessAfterInitialization=====");
        }
        return bean;
    }
    
    
}
