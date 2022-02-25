package com.zensar.blog.util;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myEndPoint")
public class MyEndPoint {
	
	// http://localhost:8080/my-actuator/myEndPoint/40
	@ReadOperation
	public String hello(@Selector int id) {
		return "Hello from custom end point"+id;
	}
	
	

}
