package com.hibernate.relations.repository;

import org.springframework.stereotype.Repository;

import com.hibernate.relations.common.NaturalIdRepository;
import com.hibernate.relations.model.Tag;

@Repository
public interface TagRepository extends NaturalIdRepository<Tag, Long> {

}
