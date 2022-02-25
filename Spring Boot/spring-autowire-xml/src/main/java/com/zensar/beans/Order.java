package com.zensar.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

//@Autowired
public  class Order {
	
	//@Qualifier("myItem1")
	//@Autowired   //ref 
	private List<Item> item=new ArrayList<Item>();
	
	private Set<String> title=new HashSet<String>();
	
	private Properties properties;

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Set<String> getTitle() {
		return title;
	}

	public void setTitle(Set<String> title) {
		this.title = title;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Order [item=" + item + ", title=" + title + ", properties=" + properties + "]";
	}

	
	
	

	
}
