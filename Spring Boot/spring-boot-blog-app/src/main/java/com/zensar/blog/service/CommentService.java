package com.zensar.blog.service;

import java.util.List;

import com.zensar.blog.payload.CommentDto;

public interface CommentService {
	
  CommentDto createComment(long postId,CommentDto commentDto);
  
  void deleteComment(Long postId, Long commentId);
  
  CommentDto getCommentById(Long postId, Long commentId);

  CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);
  
  public List<CommentDto> getCommentByName(String name);
  
  List<CommentDto> getCommentsByPostId(long postId);
  
  
}
