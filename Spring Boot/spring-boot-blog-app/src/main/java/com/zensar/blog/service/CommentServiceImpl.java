package com.zensar.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.blog.entity.Comment;
import com.zensar.blog.entity.Post;
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
}
