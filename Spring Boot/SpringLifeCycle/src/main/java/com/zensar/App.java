package com.zensar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.bean.LifeCycleBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	AbstractApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
    	
    	
    	LifeCycleBean bean=context.getBean("lifeCycle",LifeCycleBean.class);
    	
    	System.out.println(bean);
    	
    	context.registerShutdownHook();
    	
    }
}
