package com.hibernate.relations.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.relations.model.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	@EntityGraph("post-comment-tag-graph")
	public Optional<Post> findById(Long id);
}
