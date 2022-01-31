package com.hibernate.relations.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@Scope("prototype")
@AllArgsConstructor
public class PresistenceManger<T extends BaseEntity,R extends CrudRepository> {

	private R repository;
	
	public List<T> getPresistenceState(List<T> objects) {
		
		List<T> objectsWithPresistenceState = new ArrayList<>();
		for(T obj : objects) {
			Optional<T> optional = repository.findById(obj.getId());
			if(optional.isPresent())
				objectsWithPresistenceState.add(optional.get());
			else
				objectsWithPresistenceState.add((T) repository.save(obj));
		}
			return objectsWithPresistenceState;
	}
	
	
	public T getPresistenceState(T object) {
		Optional<T> optional = repository.findById(object.getId());
		if(optional.isPresent())
			return object;
		else 
			return (T) repository.save(object);
			
	}
	

	
}
