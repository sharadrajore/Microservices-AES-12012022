package com.zensar.blog.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.blog.entity.Post;
import com.zensar.blog.payload.PostDto;

public interface PostService {
	public PostDto createPost(PostDto post);
	public List<Post> getAllPost();
	public PostDto getPostById(Long id) ;
	public void deletePostById(Long postId);
	public PostDto updatePost( PostDto post, Long postId);
}
