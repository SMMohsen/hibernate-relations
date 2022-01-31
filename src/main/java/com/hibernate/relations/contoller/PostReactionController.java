package com.hibernate.relations.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.relations.model.PostReaction;
import com.hibernate.relations.service.PostReactionService;

@RestController
@RequestMapping("/post-reaction")
public class PostReactionController {
	
	@Autowired
	private PostReactionService postReactionService;
	
	
	@PostMapping
	public ResponseEntity addPostReaction(@RequestBody PostReaction postReaction) {
		postReactionService.addPostReaction(postReaction);
		return ResponseEntity.accepted().build();
	}


}
