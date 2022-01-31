package com.hibernate.relations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.relations.model.PostReaction;

@Repository
public interface PostReactionRepostiory extends JpaRepository<PostReaction, Long> {

}
