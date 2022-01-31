package com.hibernate.relations.repository;

import com.hibernate.relations.model.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDetailsRepository extends JpaRepository<PostDetails,Long> {
}
