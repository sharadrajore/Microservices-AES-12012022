package com.zensar.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.zensar.blog.entity.Comment;
import com.zensar.blog.entity.Post;
import com.zensar.blog.exception.BlogAPIException;
import com.zensar.blog.exception.ResourceNotFoundException;
import com.zensar.blog.payload.CommentDto;
import com.zensar.blog.repository.CommentRepository;
import com.zensar.blog.repository.PostRepository;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));

		Comment comment = mapToEntity(commentDto);

		comment.setPost(post);

		Comment comment2 = commentRepository.save(comment);

		return mapToDto(comment2);
	}

	private Comment mapToEntity(CommentDto commentDto) {

		Comment comment = new Comment();
		comment.setId(commentDto.getId());
		comment.setName(commentDto.getName());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());

		return comment;
	}

	private CommentDto mapToDto(Comment comment) {

		CommentDto dto = new CommentDto();
		dto.setId(comment.getId());
		dto.setName(comment.getName());
		dto.setEmail(comment.getEmail());
		dto.setBody(comment.getBody());

		return dto;
	}

	@Override
	public void deleteComment(Long postId, Long commentId) {
		
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("comment", "id", postId));
		
		if(!(comment.getPost().getId()==(post.getId()))) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not blog to post");
		}
		commentRepository.deleteById(commentId);
	}

	@Override
	public CommentDto getCommentById(Long postId, Long commentId) {
		commentRepository.findById(commentId);
		
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("comment", "id", postId));
		
		if(!(comment.getPost().getId()==(post.getId()))) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not blog to post");
		}
		
		return mapToDto(comment);
	}

	@Override
	public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
