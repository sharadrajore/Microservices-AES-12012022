package com.zensar.blog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "posts")
public class Post {

	@Id
	private Long id;
	private String title;
	private String description;
	private String content;

}
