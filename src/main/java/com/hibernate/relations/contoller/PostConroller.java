package com.hibernate.relations.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.relations.model.Post;
import com.hibernate.relations.model.PostComment;
import com.hibernate.relations.model.PostDetails;
import com.hibernate.relations.model.PostReaction;
import com.hibernate.relations.model.Tag;
import com.hibernate.relations.service.PostReactionService;
import com.hibernate.relations.service.PostService;

@RestController
@RequestMapping("/post")
public class PostConroller {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostReactionService postReactionService;
	
	
	@GetMapping("/{postId}")
	public Post getPostById(@PathVariable Long postId) {
		return postService.getPostById(postId);
	}
	
	@GetMapping("/all")
	public List<Post> getAllPosts(@RequestParam(defaultValue = "0") Integer start  , @RequestParam(defaultValue = "10") Integer size) {
		return postService.getAllPosts(start, size);
	}
	
	@PostMapping
	public ResponseEntity addNewPost(@RequestBody Post post) {
		postService.addPost(post); 
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping("{postId}/comment")
	public ResponseEntity addNewComment(@PathVariable Long postId , @RequestBody PostComment postComment) {
		postService.addComment(postId, postComment);
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping("{postId}/post-details")
	public ResponseEntity addPostDetails(@PathVariable Long postId , @RequestBody PostDetails postDetails) {
		postService.addPostDetails(postId, postDetails);
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping("{postId}/tags")
	public ResponseEntity addPostTags(@PathVariable Long postId , @RequestBody List<Tag> tags) {
		postService.addTags(postId, tags);
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping("{postId}/reactions")
	public ResponseEntity addPostReactions(@PathVariable Long postId , @RequestBody PostReaction reactions) {
		postReactionService.addPostReaction_2(reactions);
		return ResponseEntity.accepted().build();
	}
	

}
