package com.hibernate.relations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.relations.model.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}
