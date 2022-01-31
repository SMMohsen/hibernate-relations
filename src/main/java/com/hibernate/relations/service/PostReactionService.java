package com.hibernate.relations.service;

import org.springframework.stereotype.Service;

import com.hibernate.relations.model.Post;
import com.hibernate.relations.model.PostReaction;
import com.hibernate.relations.model.Reaction;
import com.hibernate.relations.repository.PostReactionRepostiory;
import com.hibernate.relations.repository.PostRepository;
import com.hibernate.relations.repository.ReactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostReactionService {
	
	private PostRepository postRepository;
	private PostReactionRepostiory postReactionRepository;
	private ReactionRepository reactionRepository;
	
	
	public void addPostReaction(PostReaction postReaction) {
		Post post = postRepository.findById(postReaction.getId().getPostId()).get();
		Reaction reaction = reactionRepository.findById(postReaction.getId().getReactionId()).get();
		
		postReaction.setPost(post);
		postReaction.setReaction(reaction);
		
		postReactionRepository.save(postReaction);
	}
	
	public void addPostReaction_2(PostReaction postReaction) {
		
		postReactionRepository.save(postReaction);
	}
	

}
