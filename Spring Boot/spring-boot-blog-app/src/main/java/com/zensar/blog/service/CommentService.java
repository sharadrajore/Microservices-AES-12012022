package com.zensar.blog.service;

import com.zensar.blog.payload.CommentDto;

public interface CommentService {
  CommentDto createComment(long postId,CommentDto commentDto);
}
