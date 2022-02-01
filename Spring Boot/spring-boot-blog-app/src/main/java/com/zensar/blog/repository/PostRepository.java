package com.zensar.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
