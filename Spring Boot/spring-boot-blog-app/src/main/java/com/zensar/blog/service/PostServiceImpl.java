package com.zensar.blog.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zensar.blog.entity.Post;
import com.zensar.blog.exception.ResourceNotFoundException;
import com.zensar.blog.payload.PostDto;
import com.zensar.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	//@Autowired
	//private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto post) {

		Post postEntity = mapToEntity(post);

		Post post2 = postRepository.save(postEntity);

		PostDto dto = mapToDto(post2);

		return dto;

	}

	private PostDto mapToDto(Post post) {
		
		//PostDto dto = modelMapper.map(post, PostDto.class);
		
		PostDto dto = new PostDto();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setDescription(post.getDescription());
		dto.setContent(post.getContent());
		
		return dto;
	}

	private Post mapToEntity(PostDto post) {
		
	//	Post post2 = modelMapper.map(post,Post.class);
		Post postEntity = new Post();
		postEntity.setId(post.getId());
		postEntity.setTitle(post.getTitle());
		postEntity.setDescription(post.getDescription());
		postEntity.setContent(post.getContent());
		return postEntity;
	}

	@Override
	public List<Post> getAllPost(int pageNumber,int pageSize,String sortBy) {
		
		Pageable pageable=PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		
		Page<Post> page = postRepository.findAll(pageable);
		
		List<Post> listOfPost = page.getContent();
		
		return listOfPost;
	}

	@Override
	public PostDto getPostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(()->{throw new ResourceNotFoundException("Post", "Id", id);});
		return mapToDto(post);
	}

	@Override
	public void deletePostById(Long postId) {
		postRepository.deleteById(postId);
	}

	@Override
	public PostDto updatePost(PostDto post, Long postId) {

		PostDto availablePost = getPostById(postId);

		Post post2 = mapToEntity(availablePost);

		Post post3 = postRepository.save(post2);

		return mapToDto(post3);
	}

}
