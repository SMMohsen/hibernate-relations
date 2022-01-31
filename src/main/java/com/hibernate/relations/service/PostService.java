package com.hibernate.relations.service;

import java.util.List;

import javax.transaction.Transactional;

import com.hibernate.relations.repository.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hibernate.relations.model.Post;
import com.hibernate.relations.model.PostComment;
import com.hibernate.relations.model.PostDetails;
import com.hibernate.relations.model.Tag;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

	private PostRepository postRepository;

	private PostCommentRepository postCommentRepository;

	private PostDetailsRepository postDetailsRepository;

	private TagRepository tagRepository;



	private PostReactionRepostiory postReactionRepository;


	@Transactional
	public void addPost(Post post) {
		List<PostComment> comments = postCommentRepository.saveAll(post.getComments());
		
		post.getPostDetails().setPost(post);
		
		PostDetails postDetails = postDetailsRepository.save(post.getPostDetails());

		post.addComments(comments);
		post.setPostDetails(postDetails);

		postRepository.save(post);

	}

	public Post getPostById(Long id) {
		return postRepository.findById(id).get();
	}

	public List<Post> getAllPosts(int start, int size) {
		Pageable page = PageRequest.of(start, size);
		return postRepository.findAll(page).toList();
	}

	public void addComment(Long postId, PostComment postComment) {
		Post post = postRepository.findById(postId).get();
		//post.addComment(postComment);
		postRepository.save(post);
	}

	public void addPostDetails(Long postId, PostDetails postDetails) {
		Post post = postRepository.findById(postId).get();
		post.addPostDetails(postDetails);
		postRepository.save(post);
	}

	public void addTags(Long postId, List<Tag> tags) {
		Post post = postRepository.findById(postId).get();
		post.addTags(tags);
		postRepository.save(post);
	}


	public List<PostComment> addComments(List<PostComment> commments) {
		return postCommentRepository.saveAll(commments);
	}
	

}
