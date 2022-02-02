package com.zensar.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.blog.payload.CommentDto;
import com.zensar.blog.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;

//   /api/posts/{postId}/comments -> POST
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@PathVariable("postId") int postId,
			@RequestBody CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable("postId") long postId,@PathVariable("commentId")long commentId){
		commentService.deleteComment(postId, commentId);
		return new ResponseEntity<String>("Comment deleted Successfullyy",HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable("postId") long postId,@PathVariable("commentId") long commentId) {
		return new ResponseEntity<CommentDto>(commentService.getCommentById(postId, commentId),HttpStatus.OK);
	}

}
