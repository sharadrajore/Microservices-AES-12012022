package com.zensar.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
//	List<Comment> readByName(String name);
	
	//@Query("FROM Comment c where c.name=?1")// JPQL
	
	@Query(value = "select * FROM Comment  where name=:myName",nativeQuery = true)
	List<Comment> commentByItsName(@Param("myName")String name);
	
	//List<Comment> commentByItsNameAndEmail(String name,String email);
	
	List<Comment> getCommentsByPostId(long postId);
	
	
}
