package com.zensar.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.blog.entity.Post;

@RestController
public class PostController {

	// CRUD Created,Read,Update,Delete

	private List<Post> posts = new ArrayList<>();

	// http://localhost:8080/api/posts -> POST

	@PostMapping("/api/posts")
	public boolean createPost(@RequestBody Post post) {
		return posts.add(post);
	}

	// http://localhost:8080/api/posts -> GET
	@GetMapping("/api/posts")
	public List<Post> getAllPost() {
		return posts;
	}

	// http://localhost:8080/api/posts/{postId} -> GET
	@GetMapping("/api/posts/{postId}")
	public Post getPostById(@PathVariable("postId") Long postId) {
		System.out.println("postId is " + postId);

		for (Post post : posts) {
			if (post.getId().equals(postId)) {
				System.out.println(post);
				return post;
			}
		}
		return null;
	}

	// http://localhost:8080/api/posts/{postId} -> Delete
	@DeleteMapping("/api/posts/{postId}")
	public boolean deletePostById(@PathVariable("postId") Long postId) {
		System.out.println("postId is " + postId);

		for (Post post : posts) {
			if (post.getId().equals(postId)) {
				return posts.remove(post);
			}
		}
		return false;
	}

	@PutMapping("/api/posts/{postId}")
	public Post updatePost(@RequestBody Post post, @PathVariable("postId") Long postId) {
		Post availablePost = this.getPostById(postId);

		availablePost.setTitle(post.getTitle());
		availablePost.setContent(post.getContent());
		availablePost.setContent(post.getContent());
		return availablePost;
	}

}
