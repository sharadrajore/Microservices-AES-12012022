package com.zensar.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.blog.entity.Post;
import com.zensar.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	// CRUD Created,Read,Update,Delete
	@Autowired
	private PostService postService;

	// http://localhost:8080/api/posts -> POST

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// @RequestMapping(method=RequestMethod.POST)
	public Post createPost(@RequestBody Post post) {
		return postService.createPost(post);
	}

	// http://localhost:8080/api/posts -> GET
	@GetMapping
	public List<Post> getAllPost() {
		return postService.getAllPost();
	}

	// http://localhost:8080/api/posts/{postId} -> GET
	@GetMapping(path = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Post getPostById(@PathVariable("postId") Long id) {
		return postService.getPostById(id);
	}

	// http://localhost:8080/api/posts/{postId} -> Delete
	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable Long postId) {
		postService.deletePostById(postId);
	}

	@PutMapping("/{postId}")
	public Post updatePost(@RequestBody Post post, @PathVariable("postId") Long postId) {
		return postService.updatePost(post, postId);
	}

}
