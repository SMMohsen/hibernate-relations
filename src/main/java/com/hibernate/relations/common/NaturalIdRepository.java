package com.hibernate.relations.common;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NaturalIdRepository<T, ID> extends CrudRepository<T, ID> {

    // use this method when your entity has a single field annotated with @NaturalId
    Optional<T> findByTagName(String naturalId);

    // use this method when your entity has more than one field annotated with @NaturalId
    //Optional<T> findByNaturalId(Map<String, Object> naturalIds);        
}
