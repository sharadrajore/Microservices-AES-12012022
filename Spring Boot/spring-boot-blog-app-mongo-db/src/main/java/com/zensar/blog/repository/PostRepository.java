package com.zensar.blog.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.zensar.blog.entity.Post;

public interface PostRepository extends MongoRepository<Post, Long> {

}
