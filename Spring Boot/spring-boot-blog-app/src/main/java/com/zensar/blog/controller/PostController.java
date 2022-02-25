package com.zensar.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.blog.entity.Post;
import com.zensar.blog.payload.PostDto;
import com.zensar.blog.service.PostService;
import com.zensar.blog.util.AppConstant;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Post Resource")

public class PostController {

	// CRUD Created,Read,Update,Delete
	// @Autowired
	private PostService postService;

	// @Autowired
	public PostController(PostService service) {
		this.postService = service;
	}

	// http://localhost:8080/api/posts -> POST

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// @RequestMapping(method=RequestMethod.POST)
	@Hidden
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) {
		// postService.createPost(post);
		return new ResponseEntity<PostDto>(postService.createPost(post), HttpStatus.CREATED);
	}

	// http://localhost:8080/api/posts -> GET
	@GetMapping
	public List<Post> getAllPost(@RequestParam(value = "pageNo", defaultValue = AppConstant.PAGENO, required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy) {

		return postService.getAllPost(pageNumber, pageSize, sortBy);
	}

	// http://localhost:8080/api/posts/{postId} -> GET
	@GetMapping(path = "/{postId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Get Post by Post ID" ,description = "Get Post by Post ID")
	public @ApiResponse(description = "Post Object ")PostDto getPostById(@Parameter(description = "Enter Post Id of the Post")@PathVariable("postId") Long id) {
		return postService.getPostById(id);
	}

	// http://localhost:8080/api/posts/{postId} -> Delete
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePostById(@PathVariable Long postId) {
		postService.deletePostById(postId);
		return new ResponseEntity<String>("Post Deleted Successfullyyy !!!!", HttpStatus.OK);

	}

	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto post, @PathVariable("postId") Long postId) {
		return new ResponseEntity<PostDto>(postService.updatePost(post, postId), HttpStatus.CREATED);
	}

}
