package com.zensar.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}
