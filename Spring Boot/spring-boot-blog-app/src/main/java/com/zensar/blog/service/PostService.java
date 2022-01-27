package com.zensar.blog.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.blog.entity.Post;

public interface PostService {
	public Post createPost(Post post);
	public List<Post> getAllPost();
	public Post getPostById(Long id) ;
	public void deletePostById(Long postId);
	public Post updatePost( Post post, Long postId);
}
