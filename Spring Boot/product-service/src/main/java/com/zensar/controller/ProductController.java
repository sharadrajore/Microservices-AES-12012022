package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.rest.client.CouponClient;
import com.zensar.services.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private CouponClient couponClient;
	
	@PostMapping("/")
	@Retry(name = "product-api",fallbackMethod ="handleError" )
	public Product insertProduct(@RequestBody Product product) {
		
		// String code=product.getCouponCode();
		
		//System.out.println("code"+ code);
		
		// System.out.println("http://localhost:8082/coupons/"+code);
		
		// http://localhost:8082/coupons/{couponCode}
		
		// Coupon coupon = restTemplate.getForObject("http://localhost:8082/coupons/"+code, Coupon.class);
	  
		//Coupon coupon = restTemplate.getForObject("http://COUPON-SERVICE/coupons/"+code, Coupon.class);
	
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		
		product.setPrice(product.getPrice()-coupon.getDiscount());
		
		return productService.insertProduct(product);
	}
	
	public Product handleError(Exception e) {
		System.out.println("Coupon service is down !!!");
		return new Product();
	}
	
	
	

}
