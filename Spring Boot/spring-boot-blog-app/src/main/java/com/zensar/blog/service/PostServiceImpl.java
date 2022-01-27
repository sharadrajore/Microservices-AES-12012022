package com.zensar.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.blog.entity.Post;
import com.zensar.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post getPostById(Long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public void deletePostById(Long postId) {
		postRepository.deleteById(postId);
	}

	@Override
	public Post updatePost(Post post, Long postId) {
		Post availablePost = getPostById(postId);
		availablePost.setTitle(post.getTitle());
		availablePost.setDescription(post.getDescription());
		availablePost.setContent(post.getContent());
		postRepository.save(availablePost);
		return availablePost;
	}

}
