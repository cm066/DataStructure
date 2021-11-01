package com.mc.env;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cm
 * @create 2021/10/23-8:29 上午
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        super.setAllowBeanDefinitionOverriding(false);
        super.setAllowCircularReferences(false);
//        super.customizeBeanFactory(beanFactory);
        super.customizeBeanFactory(beanFactory);
    }

    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        //这里可以自定义参数的验证
//        getEnvironment().setActiveProfiles();
    }
}
