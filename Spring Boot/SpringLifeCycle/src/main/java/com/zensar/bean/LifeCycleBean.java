package com.zensar.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class LifeCycleBean implements BeanNameAware,DisposableBean{
	
	private String title;
	
	public LifeCycleBean() {
		System.out.println("Inside LifeCycleBean()");
	}
	
	
	
	
	public LifeCycleBean(String title) {
		super();
		this.title = title;
	}




	public void myInit() {
		System.out.println("Inside myInit()");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		System.out.println("Inside setTitle(String title) !!!");
		this.title = title;
	}

	@Override
	public String toString() {
		return "LifeCycleBean [title=" + title + "]";
	}


	@Override
	public void setBeanName(String name) {
		System.out.println("Bean id/name is "+name);
		
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("Inside destroy");
		
	}
	
	

}
