package com.zensar.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Post {
	
	@Id
	private Long id;
	private String title;
	private String description;
	private String content;
	
	
	
	

}
